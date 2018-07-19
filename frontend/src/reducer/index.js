import { combineReducers } from 'redux';
import CampaignReducer from './CampaignReducer';
import AppReducer from './AppReducer';

export default combineReducers({
  app: AppReducer,	
  campaign: CampaignReducer
});