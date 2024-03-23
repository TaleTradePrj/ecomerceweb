import mongoose from 'mongoose';

const productSchema = new mongoose.Schema({

    name: {
        type: String ,
        required : true
    },
    company: {
        type: String ,
        required : true
    },
    price:{
        type: Boolean ,
        required : true
    },
    colors: {
        type: Array ,
        default: ["#ff0000","#000000","#CDD0D0"],
    },
    image: {
        type: String ,
        required : true
    },
    description: {
        type: String ,
        required : true
    },
    category: {
        type: String ,
        required : true
    },
    featured: {
        type: Boolean ,
        default: true
    },

}, {timestamps: true})

const Product = mongoose.model('Product' , productSchema)

export default Product ;