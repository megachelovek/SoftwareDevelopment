import ReactDOM from 'react-dom';
import React from 'react';
import './index.css';
//import './modules/main.css';
import './modules/table2/table.css'
import App from './App';
import {BrowserRouter, Route, Switch} from "react-router-dom";

import CarPage from './modules/carPage';
import CarpartPage from './modules/carpartPage';
import CompanyPage from './modules/companyPage';
import ShopPage from './modules/shopPage';
import EditObjectPage from './modules/editObjectPage';
import * as serviceWorker from './serviceWorker';

const rootElement = document.getElementById("root");
ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={App} />
      <Route path="/editPage" component={EditObjectPage} /> 
      <Route path="/carpage" component={CarPage} />
      <Route path="/carpartpage" component={CarpartPage} />
      <Route path="/shoppage" component={ShopPage} />
      <Route path="/companypage" component={CompanyPage} />
    </Switch>
  </BrowserRouter>,
  rootElement
);

serviceWorker.unregister();
