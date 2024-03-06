import mongoose from "mongoose";

const userSchema = mongoose.Schema({
    name: {
        type: String , 
    },
    email: {
        type: String,
        required: true,
        unique: true
    },
    phoneNumber: {
        type: Number,
        unique: true
    },
    password: {
        type: String ,
        required: true
    },
    customerID: {
        type: mongoose.Schema.Types.ObjectId, 
        default: () => new mongoose.Types.ObjectId(),
        unique: true
    }
    
})

const User = mongoose.model('User' , userSchema);

export default User;
