import React, { useState } from 'react'

export default function AdminProducts() {

  const [categorySelect, setSelectedCategory] = useState('')

  const addProduct = async(e) => {
    e.preventDefault()
  }

  return (
    <div className="flex flex-col min-h-screen w-screen">
      <span className='text-4xl font-bold p-10'>Add Product</span>
      <form className='flex flex-col ms-5' onSubmit={addProduct}>
        <div className="flex w-full items-center mb-10">
          <span className='text-3xl me-3'>Name: </span>
          <input type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Product name' id='name' name='name'></input>
          <span className='ms-5 text-3xl me-3'>Company: </span>
          <input type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Apple' id='company' name='company'></input>
        </div>
        <div className="flex w-full items-center">
          <span className='text-3xl me-3'>Price: </span>
          <input type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='1000' id='price' name='price'></input>
          <span className='ms-5 text-3xl me-3'>Image: </span>
          <input type='file' className='normal-case rounded-2xl text-2xl' placeholder='Image' id='image' name='image'></input>
        </div>
        <div className="mt-10 flex w-full items-center">
          <span className='text-3xl me-3'>Description: </span>
          <textarea type="text" className='text-3xl h-32 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Description of the product' id='name' name='name'></textarea>
          <span className='ms-5 text-3xl me-3'>Category: </span>
          <select value={categorySelect} onChange={(e) => {setSelectedCategory(e.target.value)}} name='categoryselect' id='categoryselect' className='w-1/4 border text-3xl border-gray-700 rounded-lg outline-0 focus:border-gray-700'>
            <option value="mobile">Mobile</option>
            <option value="laptop">Laptop</option>
            <option value="computer">Computer</option>
            <option value="accessories">Accessories</option>
            <option value="watch">Watch</option>
          </select>
        </div>
        <div className="flex w-1/2 items-center justify-center">
          <button type='submit' className='mt-10 p-7 ps-2 pe-2 w-96 bg-yellow-500 text-white rounded-full hover:bg-yellow-500/75'>Submit</button>
        </div>
      </form>
      <div className="flex flex-col w-full h-1/2 divide-y-4 divide-double">
          <span className='text-4xl font-bold mt-10 mb-10 ms-10'>Products</span>
          <div className="mt-5 flex flex-col ms-5 divide-y-2 divide-solid">
              <span className='text-3xl mt-3'>PRODUCT ID: </span>
              <span className='text-3xl mt-3 text-gray-700/75'>PRODUCT NAME: </span>
              <span className='text-3xl mt-3 text-gray-700/75'>PRICE: </span>
          </div>

          <div className="mt-10 flex flex-col ms-5 divide-y-2 divide-solid">
              <span className='text-3xl mt-3'>PRODUCT ID: </span>
              <span className='text-3xl mt-3 text-gray-700/75'>PRODUCT NAME: </span>
              <span className='text-3xl mt-3 text-gray-700/75'>PRICE: </span>
          </div>
      </div>
    </div>
  )
}
