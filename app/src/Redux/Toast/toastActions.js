import * as type from '../actionTypes';

export function showToast(toast) {
  return function(dispatch) {
    dispatch(application_set_toast(toast));
    // dispatch(application_set_toast(null));
  };
}

function application_set_toast(toast) {
  return { type: type.APPLICATION_SET_TOAST, toast };
}
