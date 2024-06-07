import { logout, refreshTokenIfExpired } from '../index';

export const createHeader = (accept, contentType) => {
  return {
    Accept: accept,
    'Content-Type': contentType,
    'Accept-Language': 'bs',
  };
};

export function put(endpoint, body, actions) {
  if (actions.beginAction) {
    actions.beginAction();
  }
  return refreshTokenIfExpired().then(() =>
    fetch(endpoint, {
      method: 'PUT',
      headers: createHeader('application/json', 'application/json'),
      body: JSON.stringify(body),
    }).then((response) => {
      const data = response.json();
      if (response.status === 200) {
        return data;
      }
      data.then((errors) =>
        actions.errorAction({
          type: 'ERROR',
          message: processResponse(response.status, errors),
        })
      );
      return null;
    })
  );
}

export function post(endpoint, body, actions) {
  if (actions.beginAction) {
    actions.beginAction();
  }
  return fetch(endpoint, {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(body),
  }).then((response) => {
    const data = response.json();
    if (response.status === 200) {
      return data;
    }
    data.then((errors) => {
      if (actions.errorAction) {
        actions.errorAction({
          type: 'ERROR',
          message: processResponse(response.status, errors),
        });
      }
    });
    return null;
  });
}

export function get(endpoint, params, actions) {
  const urlParams = createGetUrLParams(params);
  if (actions.beginAction) {
    actions.beginAction();
  }
  return refreshTokenIfExpired().then(() =>
    fetch(endpoint + urlParams, {
      method: 'GET',
      headers: createHeader('application/json', 'application/json'),
    }).then((response) => {
      const data = response.json();
      if (response.status === 200) {
        return data;
      }
      processErrors(data, actions, response.status);
      return null;
    })
  );
}

function createGetUrLParams(params) {
  let urlParams = '?';
  Object.keys(params).forEach((key) => (urlParams += key + '=' + params[key] + '&'));
  urlParams = urlParams.substring(0, urlParams.length - 1);
  return urlParams;
}

export function sendXmlMessage(endpoint, body, actions) {
  if (actions.beginAction) {
    actions.beginAction();
  }
  return refreshTokenIfExpired().then(() =>
    fetch(endpoint, {
      method: 'POST',
      headers: createHeader('application/json', 'application/xml'),
      body: body,
    }).then((response) => {
      const data = response.json();
      if (response.status === 200) {
        return data;
      }
      processErrors(data, actions, response.status);
      return null;
    })
  );
}

const processErrors = (data, actions, status) => {
  data.then((errors) =>
    actions.errorAction({
      type: 'ERROR',
      message: processResponse(status, errors),
    })
  );
};

function processResponse(status, data) {
  let message = '';
  if (status === 400) {
    if (data.message) message = data.message + ' \n';
    if (data.subErrors) {
      data.subErrors.forEach((error, index) => {
        message += error.message + ',';
      });
    }
    console.error(' Status 400 - Bad request!');
  }
  if (status === 401 || status === 403 || status === 440) {
    logout();
  }
  if (status === 404) {
    if (data.message) message = data.message;
    if (data.subErrors) {
      data.subErrors.forEach((error, index) => {
        message = message + (index + 1) + '.' + error.field + '-' + error.message;
      });
    }
    console.error('Status 404 - Page not found!');
  }
  if (status === 409) {
    if (data.message) message = data.message;
    if (data.subErrors) {
      data.subErrors.forEach((error, index) => {
        message = message + (index + 1) + '.' + error.field + '-' + error.message;
      });
    }
    console.error('Status 409 - Conflict!');
  }
  if (status === 500) {
    if (data.message) message = data.message;
    if (data.subErrors) {
      data.subErrors.forEach((error, index) => {
        message = message + (index + 1) + '.' + error.field + '-' + error.message;
      });
    }
    console.error('Status 500 - Server error!');
  }
  return message;
}
