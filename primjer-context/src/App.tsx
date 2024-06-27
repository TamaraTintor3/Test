import { createContext, useReducer } from 'react';
import './App.css';
import UserForm from './UserForm';
import UserView from './UserView';
import { Actions } from './actions/actions';
import userReducer from './reducer/reducer';
import { IUser, initialState } from './state/userState';

export const UserContext = createContext<{
  user: IUser;
  dispatch: React.Dispatch<Actions>;
}>({
  user: initialState,
  dispatch: () => undefined,
});

const App = () => {
  const [user, dispatch] = useReducer(userReducer, initialState);
  return (
    <UserContext.Provider value={{ user, dispatch }}>
      <div className='App'>
        <UserForm />
        <UserView />
      </div>
    </UserContext.Provider>
  );
};

export default App;
