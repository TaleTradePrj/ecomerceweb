import { createSlice} from '@reduxjs/toolkit';

const initialState ={
    currentUser:null,
    loading:false
}

const UserSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        login: (state, action) => {
            state.currentUser = action.payload;
        },
        logout: (state) => {
            state.currentUser = null;
        },
        loadingStart: (state) => {
            state.loading = true;
        },
        loadingEnd: (state) => {
            state.loading = false;
        }
        
    },
});


export const { login, loginProgress, loginFailure, logout , loginSuccess , loadingStart , loadingEnd} = UserSlice.actions;

export default UserSlice.reducer;