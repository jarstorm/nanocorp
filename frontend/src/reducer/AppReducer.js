import {
  LOADED_DATA,
  LOADED_CHILDREN,
  RELOAD_DATA,
  RELOAD_CHILDREN,
  LOAD_USER,
  LOGIN_OK,
  LOGIN_KO
} from '../action/types';

const INITIAL_STATE = {
  logged: false,
  token: null
};

export default (state = INITIAL_STATE, action) => {
	console.log(action);
  switch (action.type) {
    case LOGIN_OK:      
      return { ...state, logged: true };
    case LOGIN_KO:
      return { ...state, logged: false };    
    default:
      return state;
  }
};