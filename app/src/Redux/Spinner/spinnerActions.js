import * as type from '../actionTypes';
export const setSpinnerFlag = (value) => {
  return (dispatch) => {
    dispatch(application_set_loading_value(value));
  };
};

function application_set_loading_value(value) {
  return {
    type: type.SPINNER_SET_LOADING_VALUE,
    value,
  };
}
