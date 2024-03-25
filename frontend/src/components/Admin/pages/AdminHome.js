import React, { useEffect, useState } from 'react'
import axios from 'axios';

import {Users, ShoppingBag} from "@phosphor-icons/react/dist/ssr";

export default function AdminHome(props) {

  const pageFunc = props.pageFunc

  const hr = (new Date()).getHours()
  const currentGreet = () => {
    if (hr < 12) {
      return "Morning!";
    } else if (hr === 12 || hr < 17) {
      return "Afternoon!";
    } else if (hr >= 17) {
      return "Evening!";
    }
  };

  const[count , setCount] = useState({});


  const fetchCount = async() => {

    await axios.get("http://localhost:5000/api/admin/count")
    .then((res) => {
      setCount(res.data);
    })
    .catch((err) => {
      console.log(err)
    })

  } 


  useEffect(() => {
    fetchCount();
  },[])


  return (
    <div className='flex w-screen min-h-screen bg-transparent'>
      <div className='flex flex-col w-full'>
        <p className='text-4xl useinter ps-5 pt-5 text-black font-bold'>Dashboard</p>
        <p className='text-2xl useinter ps-4 pt-1 text-slate-500/75 font-semibold'>Hello Admin, Good {currentGreet()}</p>
        <div className="flex w-full pe-10">
          <div className='flex flex-col bg-[#4287f5] border border-transparent rounded-lg ms-5 mt-3 w-1/5 md:w-1/6 h-20 md:h-64 p-4 justify-center items-center cursor-pointer hover:bg-[#4287f5]/75 select-none' onClick={() => {pageFunc("users")}}>
            <span className='text-3xl md:text-5xl useinter font-bold text-white'>{count.userCount}</span>
            <span className='text-sm md:text-2xl useinter font-semibold text-white'>Users</span>
            <div className='hidden md:flex'>
              <Users size={72} className='text-white'/>
            </div>
          </div>
          <div className='flex flex-col bg-[#4287f5] border border-transparent rounded-lg ms-5 mt-3 w-1/5 md:w-1/6 h-20 md:h-64 p-4 justify-center items-center cursor-pointer hover:bg-[#4287f5]/75 select-none' onClick={() => {pageFunc("products")}}>
            <span className='text-3xl md:text-5xl useinter font-bold text-white'>{count.productCount}</span>
            <span className='text-sm md:text-2xl useinter font-semibold text-white'>Products</span>
            <div className='hidden md:flex'>
              <ShoppingBag size={72} className='text-white'/>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
