import { Actions, ActionType } from '../actions/actions';
import { IUser } from '../state/userState';

function userReducer(state: IUser, action: Actions): IUser {
  switch (action.type) {
    case ActionType.ON_CHANGE: {
      return {
        ...state,
        name: action.payload.name,
        age: action.payload.age,
      };
    }
    case ActionType.CLEAR: {
      console.log(' u reducer ', state);
      return {
        ...state,
        name: '',
        age: 0,
      };
    }
    default:
      return state;
  }
}

export default userReducer;
