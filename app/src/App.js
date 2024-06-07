import { createBrowserHistory } from 'history';
import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter } from 'react-router-dom';
import { applyMiddleware, compose, createStore } from 'redux';
import thunk from 'redux-thunk';
import './App.css';
import Routes from './Routes/Routes';
import rootReducer from './rootReducer';
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(rootReducer, composeEnhancers(applyMiddleware(thunk)));

function App(props) {
  const history = createBrowserHistory();
  return (
    <div className='App'>
      <Provider store={store}>
        <BrowserRouter history={history}>
          <Routes />
        </BrowserRouter>
      </Provider>
    </div>
  );
}

export default App;
