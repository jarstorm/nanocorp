import {  
  LOADED_CAMPAIGNS,
  LOADED_CAMPAIGN_DETAIL
} from '../action/types';

const INITIAL_STATE = {
  data: [],
  detail: { platforms: []}
};

export default (state = INITIAL_STATE, action) => {
	console.log(action);
  switch (action.type) {
    case LOADED_CAMPAIGNS:
      return { ...state, data: action.payload};    
    case LOADED_CAMPAIGN_DETAIL:
      return { ...state, detail: action.payload};      
    default:
      return state;
  }
};