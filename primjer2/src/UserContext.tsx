import React, { ReactNode, createContext, useReducer } from 'react';
import { Actions } from './actions/actions';
import userReducer from './reducer/reducer';
import initialState, { IUser } from './state/userState';

interface UserContextType {
  user: IUser;
  dispatch: React.Dispatch<Actions>;
}

const UserContext = createContext<UserContextType | undefined>(undefined);

interface UserProviderProps {
  children: ReactNode;
}

const UserProvider: React.FC<UserProviderProps> = ({ children }) => {
  const [user, dispatch] = useReducer(userReducer, initialState);
  return <UserContext.Provider value={{ user, dispatch }}>{children}</UserContext.Provider>;
};

export { UserContext, UserProvider };
