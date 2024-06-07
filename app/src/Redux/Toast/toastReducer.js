import * as type from '../actionTypes';
import initialState from '../initialState';

export default function applicationReducer(state = initialState.application, action) {
  switch (action.type) {
    case type.APPLICATION_SET_TOAST: {
      return { ...state, toast: action.toast };
    }
    default: {
      return { ...state };
    }
  }
}
