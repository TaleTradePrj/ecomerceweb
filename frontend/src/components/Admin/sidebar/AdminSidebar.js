import React, { useState } from 'react'
import AdminLogoutBt from './AdminLogoutBt'
import { ShoppingCart } from "lucide-react"
import AdminSideOption from './AdminSideOption'

export default function AdminSidebar({currentPage, setCurrentPage}) {

  return (
    <div className='bg-white w-1/6 min-h-screen border-r-2 border-gray-300/50 flex'>
        <div className="flex flex-col mt-10 ms-12 w-full h-full me-7">
            <div className='flex justify-center items-center gap-3 mb-16 self-start'>
                <ShoppingCart size={22}/>
                <span className='text-4xl font-semibold'>Admin</span>
            </div>
            <AdminSideOption setCurrentPage={setCurrentPage} name='dashboard' option={currentPage}/>
            <AdminSideOption setCurrentPage={setCurrentPage} name='users' option={currentPage}/>
            <AdminSideOption setCurrentPage={setCurrentPage} name='products' option={currentPage}/>
            <div className='flex flex-col h-full justify-end mb-16'>
                <AdminLogoutBt/>
            </div>
        </div>
    </div>
  )
}
