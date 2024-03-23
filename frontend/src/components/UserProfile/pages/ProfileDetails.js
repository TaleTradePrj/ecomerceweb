import React from 'react'
import { CircleUserRound } from 'lucide-react';

export default function ProfileDetails() {
  return (
    <div className='w-screen h-screen flex flex-col items-center'>
        <CircleUserRound className='mt-7' size={150} strokeWidth="1.25px"/>
        <span className='text-3xl mt-3'>Example name</span>
        <span className='text-3xl mt-3 text-gray-700/75'>Email: example@gmail.com</span>
        <span className='text-3xl mt-3 text-gray-700/75'>Phone: +91XXXXXXXXXX</span>
    </div>
  )
}
