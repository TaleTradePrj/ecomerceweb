import React from 'react'
import { CircleUserRound } from 'lucide-react';

export default function ProfileDetails() {
  return (
    <div className='w-screen h-screen flex flex-col items-center'>
        <CircleUserRound className='mt-7' size={150} strokeWidth="1.25px"/>
        <span className='text-3xl mt-3'>Bijo Prasad</span>
        <span className='text-3xl mt-3 text-gray-700/75'>Email: bijop007@gmail.com</span>
        <span className='text-3xl mt-3 text-gray-700/75'>Phone: +91 89219 63380</span>
    </div>
  )
}
