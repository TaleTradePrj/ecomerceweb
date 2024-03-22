import React, { useState } from 'react'
import AdminSidebar from './sidebar/AdminSidebar'
import AdminHome from './pages/AdminHome'
import AdminProducts from './pages/AdminProducts'

const UserPage = (currentPage) => {
    switch(currentPage){
        case "dashboard":
            return <AdminHome/>
        case "products":
            return <AdminProducts/>
        default:
            return <AdminHome/>
    }
}

export default function AdminDash() {

    const [currentPage, setCurrentPage] = useState("dashboard")
  return (
    <div className='min-h-screen min-w-screen bg-white useroboto flex overflow-hidden'>
        <AdminSidebar currentPage={currentPage} setCurrentPage={setCurrentPage}/>
        {UserPage(currentPage)}
    </div>
  )
}
