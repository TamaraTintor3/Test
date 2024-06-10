import { useContext } from 'react';
import { UserContext } from './UserContext';
import { ActionType } from './actions/actions';

const UserForm = () => {
  const context = useContext(UserContext);

  const handleClear = () => {
    context?.dispatch({ type: ActionType.CLEAR });
  };

  return (
    <>
      <div>
        <label>
          Name:
          <input
            type='text'
            value={context?.user.name}
            onChange={(e) =>
              context?.dispatch({
                type: ActionType.ON_CHANGE,
                payload: { name: e.target.value, age: context?.user.age },
              })
            }
          />
        </label>
      </div>
      <div>
        <label>
          Age:
          <input
            type='number'
            value={context?.user.age}
            onChange={(e) =>
              context?.dispatch({
                type: ActionType.ON_CHANGE,
                payload: { name: context?.user.name, age: e.target.value as any },
              })
            }
          />
        </label>
      </div>
      <button type='button' onClick={handleClear}>
        Clear
      </button>
    </>
  );
};

export default UserForm;
