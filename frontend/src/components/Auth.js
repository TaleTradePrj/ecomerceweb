import React, { useState } from 'react'
import LogIcon from './LogIcon'
import { Eye, EyeOff } from 'lucide-react'
import { useNavigate } from 'react-router-dom'
import Swal from 'sweetalert2'
import axios from 'axios'
import {  useDispatch } from 'react-redux'
import { login } from '../redux/UserSlice.js'

export default function Auth(props) {
    const [isLogin, setIsLogin] = useState('login')
    const [passInput, setPassInput] = useState(false)
    const [isPassHidden, setisPassHidden] = useState(true)

    const [loginDetails , setLoginDetails] = useState({
      email: "",
      password: "",
    })

    const dispatch = useDispatch();

    const navigate = useNavigate();

    const handleSubmit = async(e) =>{
      e.preventDefault();
      if (isLogin === 'login'){

        await axios.post("http://localhost:5000/api/auth/login" , {email:loginDetails.password , password:loginDetails.email} )
        .then((res) => {
          console.log(res)
           dispatch(login(res.data))
          navigate('/home');})
        .catch(() => {
          Swal.fire({
            title: 'Invalid Credential!',
            text: 'Please Try Again',
            icon: 'error',
            confirmButtonText: 'OK'
          })
        })


      }
      else{
          await axios.post("http://localhost:5000/api/auth/sign-up" , {email:loginDetails.password , password:loginDetails.email})
          .then(() => {
            Swal.fire({
              title: 'Registered Succesfully',
              text: 'Welcome',
              icon: 'success',
              confirmButtonText: 'OK'
            })
            
          })
          .catch((err) => {
            Swal.fire({
              title: 'Cant Register',
              text: err,
              icon: 'error',
              confirmButtonText: 'OK'
            })
          })
      }
    }

  return (
    <section className="flex w-screen h-screen flex justify-center md:items-center scale-150">
        <div className="flex flex-col w-[25rem] h-[44.625rem] md:m-20 justify-start items-center md:border border-gray-700/10 rounded-md pt-10">
            <LogIcon/>
            <span className="text-2xl font-sans pt-2">Welcome</span>
            <span className="text-sm font-sans text-gray-900/50 pt-2">{isLogin === 'login'? "Login":"Signup"} to continue to Ecommerce</span>
            <input className="w-4/5 h-[3.25rem] border rounded-lg border-gray-700/10 outline-0 p-3 mt-5 hover:border-[#6254f3] focus:border-[#6254f3] bg-transparent text-gray-700 placeholder-gray-400 font-sans" 
            onChange={(e) => setLoginDetails({ ...loginDetails, email: e.target.value })
          }
            placeholder="Email address" type="email" style={{textTransform: "none"}}></input>
            <div className={`flex w-4/5 h-[3.25rem] mt-5 justify-evenly items-center border rounded-lg ${passInput ? "border-[#6254f3]" : "border-gray-700/10"} hover:border-[#6254f3] font-sans`}>
              <input type={isPassHidden ? "password" : "text"}
              onChange={(e) => setLoginDetails({ ...loginDetails, password: e.target.value })
            }
              className="ms-2 h-full w-4/5 outline-0 border-0 bg-transparent shadow-none" onFocus={() => {setPassInput(!passInput)}} onBlur={() => {setPassInput(!passInput)}} placeholder="Password" style={{textTransform: "none"}}/>
              {isPassHidden ? <Eye className="text-gray-900/50 hover:bg-gray-700/10 w-1/6 h-full p-3.5" onClick={() => {setisPassHidden(!isPassHidden)}}/> : <EyeOff className="text-gray-900/50 hover:bg-gray-700/10 w-1/6 h-full p-3.5" onClick={() => {setisPassHidden(!isPassHidden)}}/>}
            </div>
            <button 
            onClick={(e) => handleSubmit(e)}
            className="w-4/5 h-[3.25rem] bg-[#6254f3] text-white text-lg rounded-md mt-5 hover:bg-[#6254f3]/90 font-sans">{isLogin === "login" ? "Login" : "Sign up"}</button>
            <span className="text-sm font-sans text-gray-900/50 self-start ms-10 mt-5">{isLogin === "login" ? "Don't have an account?" : "Already have an account?"} <span className="text-[#6254f3] cursor-pointer font-medium" onClick={() => {isLogin === "login" ? setIsLogin('signup') : setIsLogin('login')}}>{isLogin === "login" ? "Sign up" : "Log in"}</span></span>
        </div>
    </section>
  )
}
