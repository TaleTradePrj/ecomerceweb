import React, { useEffect, useState } from 'react'
import axios from 'axios'

export default function AdminUsers() {

  const [users , setUsers] = useState([]);

  const fetchUsers = async() => {

    await axios.get("http://localhost:5000/api/admin/list-users")
    .then((res) => {
        setUsers(res.data)
    })
    .catch((err) => {
      console.log(err)
    })

  }

  useEffect(() => {

    fetchUsers();

  } ,[])

  console.log(users)

  return (
    <div className="flex flex-col min-h-screen w-screen items-center divide-y-4 divide-double">
        <span className='text-4xl font-bold mt-10 mb-10'>Users</span>
        {users.map((user) => {
          return(
            <div key={user._id} className="mt-10 flex flex-col ms-5 divide-y-2 divide-solid">
              <span className='text-3xl mt-3 text-gray-700/75'>Email: {user.email}</span>
              <span className='text-3xl mt-3 text-gray-700/75'>CustomerID: {user.customerID}</span>
            </div>
          )
        } )}
    </div>
  )
}
