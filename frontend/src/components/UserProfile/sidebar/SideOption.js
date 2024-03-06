import React, { useState } from 'react'
import { Package, Star} from "lucide-react"

const SideIcon = (name) => {
    switch(name){
        case 'orders':
            return <Package className='me-5' size={24} strokeWidth='1.25px'/>
        case 'reviews':
            return <Star className='me-5' size={22} strokeWidth='1.25px'/>
        default:
            return <Package className='me-5' size={24} strokeWidth='1.25px'/>
    }
}

function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

export default function SideOption({name, option, setCurrentPage}) {
  return (
    <div className={`flex h-16 w-full gap-3 self-start mb-7 border border-transparent rounded-lg hover:bg-slate-400/15 ${option === name ? "bg-slate-400/15" : ""} select-none cursor-pointer`}>
        <div className="flex self-start p-3" onClick={() => {setCurrentPage(name)}}>
            {SideIcon(name)}
            <span className='text-3xl font-medium'>{capitalize(name)}</span>
        </div>
    </div>
  )
}
