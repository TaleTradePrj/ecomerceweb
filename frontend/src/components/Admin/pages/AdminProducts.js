import React, { useEffect, useState } from 'react'
import axios from 'axios';

export default function AdminProducts() {

  const [categorySelect, setSelectedCategory] = useState('mobile')

  const [products , setProducts] = useState([]);

  const [formData , setFormData] = useState({
    name: "", 
    company: "", 
    price: "", 
    description: "", 
    category: "", 
    image: null 
  });

  const addProduct = async(e) => {
    e.preventDefault()
    await axios.post("http://localhost:5000/api/admin/add-products",formData, {headers: {'Content-Type': 'multipart/form-data'}})
    .then((res) => {
      console.log(res)
    })
    .catch((error) => {
      console.log(error)
    })

  }

  const fetchProduct = async() => {

    await axios.get("http://localhost:5000/api/admin/list-products")
    .then((res) => {
      setProducts(res.data)
    })
    .catch((err) => {
      console.log(err)
    })

  }

  useEffect(() => {
    fetchProduct();
  } ,[])

  return (
    <div className="flex flex-col min-h-screen w-screen mb-5">
      <span className='text-4xl font-bold p-10'>Add Product</span>
      <form className='flex flex-col ms-5' onSubmit={addProduct} encType="multipart/form-data">
        <div className="flex w-full items-center mb-10">
          <span className='text-3xl me-3'>Name: </span>
          <input 
          onChange={(e) => setFormData({...formData , name: e.target.value})}
          type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Product name' id='name' name='name'></input>
          <span className='ms-5 text-3xl me-3'>Company: </span>
          <input 
          onChange={(e) => setFormData({...formData , company: e.target.value})}
          type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Apple' id='company' name='company'></input>
        </div>
        <div className="flex w-full items-center">
          <span className='text-3xl me-3'>Price: </span>
          <input 
          onChange={(e) => setFormData({...formData , price: e.target.value})}
          type="text" className='text-3xl h-10 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='1000' id='price' name='price'></input>
          <span className='ms-5 text-3xl me-3'>Image: </span>
          <input 
          onChange={(e) => setFormData({...formData , image: e.target.files[0]})}
          type='file' className='normal-case rounded-2xl text-2xl' placeholder='Image' id='image' name='image'></input>
        </div>
        <div className="mt-10 flex w-full items-center">
          <span className='text-3xl me-3'>Description: </span>
          <textarea 
          onChange={(e) => setFormData({...formData , description: e.target.value})}
          type="text" className='text-3xl h-32 w-1/2 p-6 border rounded-lg bg-gray-100 normal-case outline-0 border-gray-400/50 focus:border-gray-900/50' placeholder='Description of the product' id='name' name='name'></textarea>
          <span className='ms-5 text-3xl me-3'>Category: </span>
          <select value={categorySelect}
          onChange={(e) => {
            setFormData({...formData , category: e.target.value})
            setSelectedCategory(e.target.value)
          }}
          name='categoryselect' id='categoryselect' className='w-1/4 border text-3xl border-gray-700 rounded-lg outline-0 focus:border-gray-700'>
            <option value="mobile">Mobile</option>
            <option value="laptop">Laptop</option>
            <option value="computer">Computer</option>
            <option value="accessories">Accessories</option>
            <option value="watch">Watch</option>
          </select>
        </div>
        <div className="flex w-1/2 items-center justify-center">
          <button 
          
          type='submit' className='mt-10 p-7 ps-2 pe-2 w-96 bg-yellow-500 text-white rounded-full hover:bg-yellow-500/75'>Submit</button>
        </div>
      </form>
      <div className="flex flex-col w-full h-1/2 divide-y-4 divide-double">
          <span className='text-4xl font-bold mt-10 mb-10 ms-10'>Products</span>
          {products.map((items) => {
            return(
              <div key={items._id} className="mt-5 flex flex-col ms-5 divide-y-2 divide-solid">
                <span className='text-3xl mt-3'>PRODUCT ID: {items._id} </span>
                <span className='text-3xl mt-3 text-gray-700/75'>PRODUCT NAME: {items.name}</span>
                <span className='text-3xl mt-3 text-gray-700/75'>PRICE: {items.price}</span>
                <span className='text-3xl mt-3 text-gray-700/75'>CATEGORY: {items.category}</span>
                <span className='text-3xl mt-3 text-gray-700/75'>DESCRIPTION: {items.description}</span>
              </div>
            )
          })}
      </div>
    </div>
  )
}
