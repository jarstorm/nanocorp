import axios from 'axios';
import {  
  LOGIN_OK,
  LOGIN_KO,
  LOADED_CAMPAIGNS,
  LOADED_CAMPAIGN_DETAIL,
  LOGOUT
} from './types';
import {SERVER_URL} from '../../config.js';

export const login = (user, password) => {
  const url = SERVER_URL + "/login?username=" + user + "&password=" + password; 
  return (dispatch) => {    
    axios.post(url)
    .then(data => { localStorage.setItem('TOKEN', data.data.token); dispatch({ type: LOGIN_OK })})
    .catch(err => dispatch({ type: LOGIN_KO }));
  };
};

export const loadCampaignsData = () => {
  const url = SERVER_URL + "/campaign"; 
  const token = localStorage.getItem('TOKEN');
  const options = {   
     headers: {
       'Authorization': token
     }
  };
  return (dispatch) => {    
    axios.get(url, options)
    .then(data => dispatch({ type: LOADED_CAMPAIGNS, payload: data.data }))
    .catch(err => console.log(err));
  };
};

export const loadCampaign = (campaignId) => {
  const url = SERVER_URL + "/campaign/" + campaignId; 
  const token = localStorage.getItem('TOKEN');
  const options = {   
     headers: {
       'Authorization': token
     }
  };
  return (dispatch) => {    
    axios.get(url, options)
    .then(data => dispatch({ type: LOADED_CAMPAIGN_DETAIL, payload: data.data }))
    .catch(err => console.log(err));
  };
};

export const logout = () => {  
  return (dispatch) => {    
    dispatch({ type: LOGOUT });
  };
};