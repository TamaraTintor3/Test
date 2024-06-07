import * as type from '../actionTypes';
import initialState from '../initialState';
export default function spinnerReducer(state = initialState.spinner, action) {
  switch (action.type) {
    case type.SPINNER_SET_LOADING_VALUE: {
      return {
        ...state,
        loading: action.value,
      };
    }
    default: {
      return {
        ...state,
      };
    }
  }
}
