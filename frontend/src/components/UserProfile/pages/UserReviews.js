import React, { useState } from 'react'

export default function UserReviews() {
  const [selectedOrder, setSelectedOrder] = useState('')

  return (
    <div className='w-screen h-screen flex flex-col items-center'>
        <span className='text-5xl mt-5 font-medium mb-5'>Manage Reviews and Ratings</span>
        <select value={selectedOrder} onChange={(e) => {setSelectedOrder(e.target.value)}}name='orderselect' id='orderselect' className='mt-5 w-1/4 border text-3xl border-gray-700 rounded-lg outline-0 focus:border-gray-700'>
          <option value="">Select an order...</option>
          <option value="test">test hehe</option>
          {/* map it nigga
            <option key={index} value={option}>{option}</option>
            */}
        </select>

        {selectedOrder !== "" && (
          <div className='flex flex-col w-full justify-center items-center'>
            <span className='text-4xl mt-16 font-semibold'>Write a product review</span>
            <span className='text-3xl mt-7 font-medium'>Add a headline</span>
            <input className='h-2 w-1/3 mt-3 text-2xl shadow border border-gray-700/50 rounded-lg outline-0 active:shadow-yellow-700 hover:shadow-yellow-700' placeholder="What's most important to know?" style={{textTransform: "none"}}></input>
            <span className='text-3xl mt-7 font-medium'>Add a written review</span>
            <textarea className='w-1/3 h-32 mt-3 text-2xl shadow border border-gray-700/50 rounded-lg outline-0 active:shadow-yellow-700 hover:shadow-yellow-700' placeholder="What did you like or dislike? What did you use this product for?" style={{textTransform: "none"}}></textarea>
            <button className='mt-5 pt-2 pb-2 ps-10 pe-10 bg-yellow-600 rounded-full text-white text-2xl hover:bg-yellow-600/75'>Submit</button>
          </div>
        )}

        <span className='text-4xl mt-32 font-medium mb-5'>Your Reviews</span>
        <div className='flex flex-col'>
          <span className='text-3xl font-semibold mb-3'>Nice gaming chair</span>
          <span className='text-2xl font-semibold text-gray-700/50 mb-2'>PRODUCT: CLUTCH CHAIRZ Throttle Series Gaming Chair Blak/Red</span>
          <span className='text-3xl font-normal text-gray-700/90 mb-2'>Only $399, so cheap. I bought it for my friend bijo, he plays with his dog in this chair.</span>
        </div>
    </div>
  )
}
