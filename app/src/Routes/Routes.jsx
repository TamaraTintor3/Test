import React from 'react';
import { Route, Switch } from 'react-router-dom';
import MainPage from '../React/MainPage';
const Routes = (props) => {
  return (
    <Switch>
      <Route path='/' exact component={MainPage} />
    </Switch>
  );
};

export default Routes;
