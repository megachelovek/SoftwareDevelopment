import React from 'react';
import { Link } from "react-router-dom";

class Menu extends React.Component {
    render() {
      return (
        <nav>
        <div className="menuComponent">
          <div class="menuItem"><Link to="/carpage">Cars</Link></div>
          <div class="menuItem"><Link to="/carpartpage">Carparts</Link></div>
          <div class="menuItem"><Link to="/shoppage">Shops</Link></div>
          <div class="menuItem"><Link to="/companypage">Company</Link></div>
        </div>
        </nav>
      );
    }
  }

  
export default Menu;
