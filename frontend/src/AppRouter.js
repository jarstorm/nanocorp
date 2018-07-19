import React, {Component} from 'react';
import {Route, BrowserRouter, Switch } from "react-router-dom";
import Home from './Home';
import Detail from './components/Detail';

export default class AppRouter extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/detail/:campaignId" component={Detail} />
        </Switch>
      </BrowserRouter>
    )
  }
}