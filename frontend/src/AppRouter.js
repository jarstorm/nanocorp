import React, {Component} from 'react';
import {Route, BrowserRouter } from "react-router-dom";
import Home from './Home';
import MainPage from './MainPage';

export default class AppRouter extends Component {
  render() {
    return (
      <BrowserRouter>
        <div>
          <Route exact path="/" component={Home} />
          <Route path="/main" component={MainPage} />
        </div>
      </BrowserRouter>
    )
  }
}