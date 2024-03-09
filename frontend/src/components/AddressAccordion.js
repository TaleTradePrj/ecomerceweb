import { useState } from 'react'
import {CaretDown} from '@phosphor-icons/react'
import {motion, AnimatePresence} from "framer-motion"
import Swal from 'sweetalert2'
export default function AddressAccordion() {
    const [AcOpen, SetAcOpen] = useState(false)

    const handleClick = () =>{
      Swal.fire({
        title: 'Order Placed Successfully',
        text: 'Thank You for choosing us',
        icon: 'success',
        confirmButtonText: 'OK'
      })
    }

  return (
    <div className='mt-40 flex flex-col ps-3 bg-transparent border border-gray-700/50 rounded-lg mb-3 scale-150 ms-80 me-80'>
      <div className='flex items-center mb-3 justify-between me-3 mt-2 select-none' onClick={() => {SetAcOpen(!AcOpen)}}>
        <span className='text-lg font-semibold'>Order details</span>
        <motion.div animate={{rotate: !AcOpen ? 0 : 180}} transition={{duration: 0.2}}><CaretDown size={20}/></motion.div>
      </div>
      <AnimatePresence>
        {AcOpen && (
          <motion.div
            initial={{ opacity: 0}}
            animate={{ opacity: 1}}
            transition={{duration: 0.5}}>
            <dl className="-my-3 divide-y divide-gray-700/10 text-sm">
              <div className="grid grid-cols-1 gap-1 py-3 sm:grid-cols-3 sm:gap-4 justify-center items-center">
                <dt className="font-medium text-gray-900 text-lg">Name</dt>
                <input className='bg-white rounded-md h-2 outline-0 text-lg' style={{textTransform: "none"}} placeholder='Your name'></input>
              </div>

              <div className="grid grid-cols-1 gap-1 py-3 sm:grid-cols-3 sm:gap-4">
                <dt className="font-medium text-gray-900 text-lg">Phone</dt>
                <input className='bg-white rounded-md h-2 outline-0 text-lg' style={{textTransform: "none"}} placeholder='+91XXXXXXXXXX'></input>
              </div>

              <div className="grid grid-cols-1 gap-1 py-3 sm:grid-cols-3 sm:gap-4 mb-5">
                <dt className="font-medium text-gray-900 text-lg">Address</dt>
                <textarea className='bg-white rounded-md h-32 outline-0 text-lg' style={{textTransform: "none"}} placeholder='Street Lane, Place'></textarea>
              </div>
              <div className="w-full gap-1 py-3 flex justify-center items-center">
                <button
                onClick={handleClick}
                className='mt-5 pt-2 pb-2 ps-10 pe-10 bg-[#6254f3] rounded-full text-white text-xl hover:bg-[#6254f3]/75 mb-7'>Order Now</button>
              </div>
            </dl>
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  )
}
