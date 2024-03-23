import React from 'react'

export default function AdminUsers() {
  return (
    <div className="flex flex-col min-h-screen w-screen items-center divide-y-4 divide-double">
        <span className='text-4xl font-bold mt-10 mb-10'>Users</span>
        <div className="mt-10 flex flex-col ms-5 divide-y-2 divide-solid">
            <span className='text-3xl mt-3'>Name: Example name</span>
            <span className='text-3xl mt-3 text-gray-700/75'>Email: example@gmail.com</span>
            <span className='text-3xl mt-3 text-gray-700/75'>Phone: +91XXXXXXXXXX</span>
        </div>

        <div className="mt-10 flex flex-col ms-5 divide-y-2 divide-solid">
            <span className='text-3xl mt-3'>Name: Example name</span>
            <span className='text-3xl mt-3 text-gray-700/75'>Email: example@gmail.com</span>
            <span className='text-3xl mt-3 text-gray-700/75'>Phone: +91XXXXXXXXXX</span>
        </div>
    </div>
  )
}
