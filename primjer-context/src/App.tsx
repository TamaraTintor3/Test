import './App.css';
import { UserProvider } from './UserContext';
import UserForm from './UserForm';
import UserView from './UserView';

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
