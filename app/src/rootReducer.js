import { combineReducers } from 'redux';
import userDataReducer from './Redux/Actions/userDataReducer';
import spinnerReducer from './Redux/Spinner/spinnerReducer';
const rootReducer = combineReducers({
  userDataReducer,
  spinnerReducer,
});
export default rootReducer;
