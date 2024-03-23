import express from "express";
import mongoose from "mongoose";
import dotenv from "dotenv";
import authRouter from './routes/authRouter.js';
import cookieParser from "cookie-parser";
import corsMiddleware from './utils/cors.js'
import adminRouter from './routes/adminRouter.js'


dotenv.config();


const PORT = process.env.PORT | 5000 ; 

mongoose.connect(process.env.DB_URI)
.then(() =>{
    console.log("DB connected successfully");
})
.catch((error) =>{
    console.log("error caught" , error)
})

const app = express();

app.use(express.json());


app.use(corsMiddleware);

app.use(cookieParser());

app.listen(PORT, () =>{
    console.log("server is running at 3000")
})

app.use('/api/auth' ,authRouter )
app.use('/api/admin' ,adminRouter )


// creating middleware

app.use((err, req , res , next) => {

    const statusCode = err.statusCode || 500 ;

    const message = err.message || 'Internal server Error';
    
    return res.status(statusCode).json({
        success: false , 
        statusCode,
        message
    });
});