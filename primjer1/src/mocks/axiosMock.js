import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';

// Create a new instance of the mock adapter
const mock = new MockAdapter(axios);

// Mock a GET request to /api/users
mock.onGet('/api/users').reply(200, {
  users: [
    { id: 1, name: 'John Doe' },
    { id: 2, name: 'Jane Doe' },
  ],
});

export default mock;
