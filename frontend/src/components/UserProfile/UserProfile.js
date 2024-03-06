import React, { useState } from 'react'
import UserSidebar from './sidebar/UserSidebar'

const UserPage = (currentPage) => {
    switch(currentPage){
        case "profile":
            return <div>Profile</div>
        case "orders":
            return <div>Orders</div>
        case "reviews":
            return <div>Reviews</div>
        default:
            return <div>Orders</div>
    }
}

export default function UserProfile() {

    const [currentPage, setCurrentPage] = useState("profile")
  return (
    <div className='min-h-screen min-w-screen bg-white useroboto flex overflow-hidden'>
        <UserSidebar currentPage={currentPage} setCurrentPage={setCurrentPage}/>
        {UserPage(currentPage)}
    </div>
  )
}
