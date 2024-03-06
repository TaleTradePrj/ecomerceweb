import User from "../model/user.model.js";
import bcrypt from 'bcrypt';
import jwt from 'jsonwebtoken';
import { errorHandler } from "../utils/errorHandler.js";


export const login = async (req , res, next ) => {
    const {email , password } = req.body;
    try {
       const validUser = await User.findOne({email});

       if (!validUser) return next(errorHandler(404, 'User Not Found'));

       const validPassword = bcrypt.compareSync(password , validUser.password);

       if (!validPassword) return next(errorHandler(401, "Invalid Password"));

       const token = jwt.sign({id : validUser._id}, process.env.JWT_KEY)
 
       const {password: pass, ...rest} = validUser._doc ; 
 
       res
       .cookie('accessToken',token, {httpOnly: true })
       .status(200)
       .json(rest
          );
 
    } catch (error) {
       next(error);
       
    }
 }

export const signUp = async(req , res ,next) =>{

    const {name , email , password} = req.body ; 

    const hashPassword = bcrypt.hashSync( password , 10);

    const newUser = new User({name , email , password: hashPassword});

    try {
        await newUser.save();
        res
        .status(200)
        .json("User added successfully")
    } catch (error) {
        next(error);
    }
}