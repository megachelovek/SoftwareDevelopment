import React from 'react';
import ReactRouterDOM from 'react-router-dom';
import './App.css';
import Menu from './modules/menu'

class App extends React.Component {
  render() {
    return (
      <div className="mainComponent">
        Выберите таблицу
        <Menu></Menu>
      </div>      
    );
  }
}

//ЗАПУСКАЙ NPM START все работает
export default App;
