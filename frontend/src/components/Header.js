import React from "react";
import { NavLink, useLocation } from "react-router-dom";
import styled from "styled-components";
import Nav from "./Nav";

const Header = () => {
  const location = useLocation()
   return (
    location.pathname === "/userprofile" || location.pathname === "/login" ? "" :
    <MainHeader>
      <NavLink to="/home">
        <p className="font-bold text-5xl">ShopNest</p>
      </NavLink>
      <Nav />
    </MainHeader>
  );
  
};

const MainHeader = styled.header`
  padding: 0 4.8rem;
  height: 10rem;
  background-color: ${({ theme }) => theme.colors.bg};
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: relative;

  .logo {
    height: 5rem;
  }
`;
export default Header;