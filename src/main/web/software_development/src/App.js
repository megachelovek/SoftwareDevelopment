import React from 'react';
import './App.css';
import LoginPage from './modules/loginPage'

class App extends React.Component {
  render() {
    return (
      <div className="mainComponent">
        
        <LoginPage></LoginPage>
      </div>      
    );
  }
}

//ЗАПУСКАЙ NPM START все работает
export default App;
