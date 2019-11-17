import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './modules/table/table.css'
import App from './App';
import { Router, Switch, Route, BrowserRouter } from "react-router-dom";

import CarPage from './modules/carPage';
import CarpartPage from './modules/carpartPage';
import CompanyPage from './modules/companyPage';
import ShopPage from './modules/shopPage';
import * as serviceWorker from './serviceWorker';

const rootElement = document.getElementById("root");
ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={App} />
      <Route path="/carpage" component={CarPage} />
      <Route path="/carpartpage" component={CarpartPage} />
      <Route path="/shoppage" component={ShopPage} />
      <Route path="/companypage" component={CompanyPage} />
    </Switch>
  </BrowserRouter>,
  rootElement
);

serviceWorker.unregister();
