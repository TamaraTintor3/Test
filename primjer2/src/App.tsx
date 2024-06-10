import './App.css';
import UserForm from './UseForm';
import { UserProvider } from './UserContext';
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
