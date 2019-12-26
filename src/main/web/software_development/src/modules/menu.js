import React from 'react';
import { Link } from "react-router-dom";

class Menu extends React.Component {
  render() {
    return (
      <ul className="menu">
        <li className="navitem" ><Link to="/carpage">Cars</Link></li>
        <li className="navitem" ><Link to="/carpartpage">Carparts</Link></li>
        <li className="navitem" ><Link to="/shoppage">Shops</Link></li>
        <li className="navitem" ><Link to="/companypage">Company</Link></li>
      </ul>
    );
  }
}


export default Menu;
