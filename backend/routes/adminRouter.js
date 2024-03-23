import express from 'express'; 
import { addProducts, listUsers, listProducts } from '../controller/admin.controller.js';
import { upload } from '../utils/multer.js';


const router = express.Router();

router.get('/list-users', listUsers);
router.post('/add-products', upload.fields([
    {
        name: "image",
        maxCount: 1
    },
    ]), addProducts);
router.get('/list-products', listProducts);

export default router ; 