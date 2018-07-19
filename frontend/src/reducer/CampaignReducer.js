import {
  LOADED_DATA,
  LOADED_CHILDREN,
  RELOAD_DATA,
  RELOAD_CHILDREN,
  LOAD_USER,
  LOADED_CAMPAIGNS,
  LOADED_CAMPAIGN_DETAIL
} from '../action/types';

const INITIAL_STATE = {
  data: [],
  detail: {}
};

export default (state = INITIAL_STATE, action) => {
	console.log(action);
  switch (action.type) {
    case LOADED_CAMPAIGNS:
      return { ...state, data: action.payload};    
    case LOADED_CAMPAIGN_DETAIL:
      return { ...state, data: action.payload, detail: action.payload};      
    default:
      return state;
  }
};