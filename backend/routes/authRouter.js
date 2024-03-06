import express from 'express'; 
import { login, signUp } from '../controller/auth.controller.js';

const router = express.Router();

router.post('/login', login);
router.post('/sign-up', signUp);

export default router ; 