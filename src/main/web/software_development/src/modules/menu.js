import React from 'react';
import {Link} from "react-router-dom";

class Menu extends React.Component {
    render() {
      return (
        <nav>
        <div className="menuComponent">
          <div className="menuItem"><Link to="/carpage">Cars</Link></div>
          <div className="menuItem"><Link to="/carpartpage">Carparts</Link></div>
          <div className="menuItem"><Link to="/shoppage">Shops</Link></div>
          <div className="menuItem"><Link to="/companypage">Company</Link></div>
        </div>
        </nav>
      );
    }
  }

  
export default Menu;
