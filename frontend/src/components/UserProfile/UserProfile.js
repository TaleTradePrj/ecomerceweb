import React, { useState } from 'react'
import UserSidebar from './sidebar/UserSidebar'
import ProfileDetails from './pages/ProfileDetails'
import UserOrders from './pages/UserOrders'
import UserReviews from './pages/UserReviews'

const UserPage = (currentPage) => {
    switch(currentPage){
        case "profile":
            return <ProfileDetails/>
        case "orders":
            return <UserOrders/>
        case "reviews":
            return <UserReviews/>
        default:
            return <ProfileDetails/>
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
