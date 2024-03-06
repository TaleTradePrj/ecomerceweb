import React, { useState } from 'react'
import SideOption from './SideOption'
import { ShoppingCart } from "lucide-react"
import LogoutBt from './LogoutBt'

export default function UserSidebar({currentPage, setCurrentPage}) {

  return (
    <div className='bg-white w-1/6 min-h-screen border-r-2 border-gray-300/50 flex'>
        <div className="flex flex-col mt-10 ms-12 w-full h-full me-7">
            <div className='flex justify-center items-center gap-3 mb-16 self-start'>
                <ShoppingCart size={22}/>
                <span className='text-4xl font-semibold'>ECommerce</span>
            </div>
            <SideOption setCurrentPage={setCurrentPage} name='profile' option={currentPage}/>
            <SideOption setCurrentPage={setCurrentPage} name='orders' option={currentPage}/>
            <SideOption setCurrentPage={setCurrentPage} name='reviews' option={currentPage}/>
            <div className='flex flex-col h-full justify-end mb-16'>
                <LogoutBt/>
            </div>
        </div>
    </div>
  )
}
