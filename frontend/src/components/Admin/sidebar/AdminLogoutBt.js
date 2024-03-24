import React from 'react'
import { LogOut } from 'lucide-react'
import { useNavigate } from 'react-router-dom'
import { logout } from '../../../redux/UserSlice';
import { useDispatch } from 'react-redux';


export default function AdminLogoutBt() {

  const navigate = useNavigate();

  const dispatch = useDispatch();

  const handleLogout = () => {

    navigate('/')
    dispatch(logout())


  }

  return (
    <button className='flex h-16 w-full gap-3 mb-7 border border-transparent rounded-lg hover:bg-slate-400/15 select-none cursor-pointer'>
        <div className="flex self-start p-3">
            <LogOut className='me-5' size={24} strokeWidth='1.25px'/>
            <span
            onClick={handleLogout}
            className='text-3xl font-medium'>Log out</span>
        </div>
    </button>
  )
}
