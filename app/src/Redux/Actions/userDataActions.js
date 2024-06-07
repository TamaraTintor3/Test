import * as spinnerActions from '../Spinner/spinnerActions';
import * as toastActions from '../Toast/toastActions';
import * as type from '../actionTypes';
import { post } from '../requests';

export const saveData = (userData) => {
  return (dispatch) => {
    let actions = {
      errorAction: (object) => {
        dispatch(toastActions.showToast(object));
      },
    };
    post('/api/user/add', userData, actions).then((data) => {
      if (data != null) {
        dispatch(spinnerActions.setSpinnerFlag(false));
        dispatch(
          toastActions.showToast({
            type: 'INFO',
            message: data.message,
          })
        );
      }
    });
  };
};
export const onChangeField = (data) => {
  return (dispatch) => {
    dispatch(user_data_change_field(data));
  };
};

export function user_data_change_field(data) {
  return { type: type.USER_DATA_ON_CHANGE_FIELD, data };
}
