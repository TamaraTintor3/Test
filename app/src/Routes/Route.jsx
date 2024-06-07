import React from 'react';
import { Route as DomRoute } from 'react-router-dom';

const Route = ({ path, component }) => {
  return <DomRoute path={path} component={component} />;
};

export default Route;
