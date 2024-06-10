import { useContext } from 'react';
import { UserContext } from './UserContext';

const UserView = () => {
  const context = useContext(UserContext);
  console.log(context);

  return (
    <div>
      <h1>User Info</h1>
      <p>Name: {context?.user.name}</p>
      <p>Age: {context?.user.age}</p>
    </div>
  );
};

export default UserView;
