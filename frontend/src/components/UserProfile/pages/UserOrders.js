import React from 'react'

export default function UserOrders() {
  return (
    <div className='w-screen h-screen flex flex-col items-center'>
        <span className='text-5xl mt-5 font-medium mb-5'>Your Orders</span>
        <div className="overflow-x-auto w-1/2 flex justify-center mt-5">
          <table className="divide-y-2 divide-gray-700 text-md">
            <thead className="ltr:text-left rtl:text-right">
              <tr>
                <th className="whitespace-nowrap px-4 py-2 font-semibold text-gray-900 text-3xl">ORDER ID</th>
                <th className="whitespace-nowrap px-4 py-2 font-semibold text-gray-900 text-3xl">ORDER NAME</th>
                <th className="whitespace-nowrap px-4 py-2 font-semibold text-gray-900 text-3xl">PRICE</th>
              </tr>
            </thead>

            <tbody className="divide-y divide-gray-700">
                <tr>
                    <td className="whitespace-nowrap px-4 py-2 text-gray-700 text-3xl">84589438943</td>
                    <td className="whitespace-nowrap px-4 py-2 text-gray-700 text-3xl">CLUTCH CHAIRZ Throttle Series Gaming Chair Blak/Red</td>
                    <td className="whitespace-nowrap px-4 py-2 text-gray-700 text-3xl">$399</td>
                </tr> 
            </tbody>
          </table>
        </div>
    </div>
  )
}
