import {
  LOGIN_OK,
  LOGIN_KO,
  LOGOUT
} from '../action/types';

const INITIAL_STATE = {
  logged: false,
  error: '',
  username: ''
};

export default (state = INITIAL_STATE, action) => {	
  switch (action.type) {
    case LOGIN_OK:      
      return { ...state, logged: true, error: '' };
    case LOGIN_KO:
      return { ...state, logged: false, error: 'User or password not valid' };    
    case LOGOUT:
      return INITIAL_STATE;      
    default:
      return state;
  }
};