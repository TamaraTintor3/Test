import './App.css';
import UserForm from './UseForm';
import { UserProvider } from './UserContext';
import UserView from './UserView';
/*
interface UserContextType {
  user: IUser;
  dispatch: React.Dispatch<Actions>;
}
export interface IUser {
  name: string;
  age: number;
}
export const UserContext = createContext<UserContextType | undefined>(undefined);
*/
const App = () => {
  return (
    <UserProvider>
      <div className='App'>
        <UserForm />
        <UserView />
      </div>
    </UserProvider>
  );
};

export default App;
