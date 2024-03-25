import { createContext, useContext, useEffect, useReducer } from "react";
import axios from "axios";
import reducer from "../Reducer/productReducer";

const AppContext = createContext();

const API = "https://api.pujakaitem.com/api/products";
const extendedAPI = "http://localhost:5000/api/admin/list-products"

const initialState = {
  isLoading: false,
  isError: false,
  products: [],
  featureProducts: [],
  isSingleLoading: false,
  singleProduct: {},
};

const AppProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const getProducts = async (url) => {
    dispatch({ type: "SET_LOADING" });
    try {
      const res = await axios.get(url);
      const products = await res.data;

      const res2 = await axios.get(extendedAPI)
      let extendedProducts = await res2.data

      extendedProducts = extendedProducts.map(pdt => {
        const {_id, ...rest} = pdt

        return {
          ...rest,
          id: _id,
          price: parseInt(pdt.price)
        }
      })

      extendedProducts = [...products, ...extendedProducts]
      console.log("Extended products: ", extendedProducts)

      dispatch({ type: "SET_API_DATA", payload: extendedProducts });
    } catch (error) {
      dispatch({ type: "API_ERROR" });
    }
  };

  // my 2nd api call for single product

  const getSingleProduct = async (url) => {
    dispatch({ type: "SET_SINGLE_LOADING" });
    try {
      const res2 = await axios.get(extendedAPI)
      let extendedPdts = await res2.data
      let singleProduct = {}
      const res = await axios.get(url).then(
        success => {
          singleProduct = success.data
        }
      ).catch(err => {
        console.log("err:", err.request.status)
        if(err.request.status === 404){
          const regex = /[?&]id=([^&#]*)/;
          const match = regex.exec(url);
          const pdtid = match && match[1];
  
          singleProduct = extendedPdts.find(pdt => pdt._id === pdtid)
  
          singleProduct.stock = Math.floor(Math.random() * 6) + 5
          singleProduct.reviews = Math.floor(Math.random() * 91) + 10
          singleProduct.stars = ((Math.random() * (5 - 1)) + 1).toFixed(1)
  
          const {image, _id, price, ...newSingleProduct} = singleProduct
          newSingleProduct.image = [{"id":"randomid1","width":1080,"height":650,"url": image,"filename":"prod-1.png","size":1080,"type":"image/png"},{"id":"randomid2","width":1080,"height":650,"url": image,"filename":"prod-2.png","size":1080,"type":"image/png"},{"id":"randomid3","width":1080,"height":650,"url": image,"filename":"prod-3.png","size":1080,"type":"image/png"},{"id":"randomid4","width":1080,"height":650,"url": image,"filename":"prod-4.png","size":1080,"type":"image/png"}]
          newSingleProduct.id = _id
          newSingleProduct.price = parseInt(price)

  
          singleProduct = newSingleProduct
        }
      });
      
      dispatch({ type: "SET_SINGLE_PRODUCT", payload: singleProduct });
    } catch (error) {
      dispatch({ type: "SET_SINGLE_ERROR" });
    }
  };

  useEffect(() => {
    getProducts(API);
  }, []);

  return (
    <AppContext.Provider value={{ ...state, getSingleProduct }}>
      {children}
    </AppContext.Provider>
  );
};

// custom hooks
const useProductContext = () => {
  return useContext(AppContext);
};

export { AppProvider, AppContext, useProductContext };