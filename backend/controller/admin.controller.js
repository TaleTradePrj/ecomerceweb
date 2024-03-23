import User from "../model/user.model.js";
import { errorHandler } from "../utils/errorHandler.js";
import Product from "../model/product.model.js";
import { uploadOnCloudinary } from "../utils/cloudinary.js";

export const listUsers = async (req, res, next) => {
    try {
        const findUsers = await User.find({ isAdmin: false }).select("-password -isAdmin");

        if (findUsers.length === 0) {
            return next(errorHandler(400, "Users not found"));
        }

        res.status(200).json(findUsers);
    } catch (error) {
        next(error);
    }
};

export const addProducts = async(req , res , next) => {

    try {
        const{name , company , price , description , category , featured} = req.body;

        const imagePath = req.files?.image[0]?.path;

        const uploadImage = await uploadOnCloudinary(imagePath)

        const newProduct = new Product({name , company , price , description , category , featured , image: uploadImage.url}) 

        await newProduct.save();

        res.status(200).json("product added successfully")
    } catch (error) {
        next(error);
    }

}
export const listProducts = async(req , res , next) => {

    try {
        const findProduct = await  Product.find();

        if (findProduct.length === 0) {
            return next(errorHandler(400, "Products not found"));
        }

        res.status(200).json(findProduct);

    } catch (error) {
        next(error);
    }

}
