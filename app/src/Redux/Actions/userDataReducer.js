import * as type from '../actionTypes';
import initialState from '../initialState';

export default function userDataReducer(state = initialState.addUserData, action) {
  switch (action.type) {
    case type.USER_DATA_ON_CHANGE_FIELD: {
      return {
        ...state,
        [action.data.id]: action.data.value,
      };
    }

    default: {
      return { ...state };
    }
  }
}
