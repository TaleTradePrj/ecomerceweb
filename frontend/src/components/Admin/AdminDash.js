import React, { useState } from 'react'
import AdminSidebar from './sidebar/AdminSidebar'
import AdminHome from './pages/AdminHome'
import AdminUsers from './pages/AdminUsers'
import AdminProducts from './pages/AdminProducts'


export default function AdminDash() {

    const UserPage = (currentPage) => {
        switch(currentPage){
            case "dashboard":
                return <AdminHome pageFunc={setCurrentPage}/>
            case "users":
                return <AdminUsers/>
            case "products":
                return <AdminProducts/>
            default:
                return <AdminHome/>
        }
    }

    const [currentPage, setCurrentPage] = useState("dashboard")
  return (
    <div className='min-h-screen min-w-screen bg-white useroboto flex overflow-hidden'>
        <AdminSidebar currentPage={currentPage} setCurrentPage={setCurrentPage}/>
        {UserPage(currentPage)}
    </div>
  )
}
