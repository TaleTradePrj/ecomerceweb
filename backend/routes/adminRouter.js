    import express from 'express'; 
    import { addProducts, listUsers, listProducts, count } from '../controller/admin.controller.js';
    import { upload } from '../utils/multer.js';


    const router = express.Router();

    router.get('/list-users', listUsers);
    router.post('/add-products', upload.single("image"), addProducts);
    router.get('/list-products', listProducts);
    router.get('/count', count);

    export default router ; 