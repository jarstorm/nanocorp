import axios from 'axios';
import {
  RELOAD_DATA,
  LOADED_DATA,
  RELOAD_CHILDREN,
  LOADED_CHILDREN,
  LOAD_USER,
  LOGIN_OK,
  LOGIN_KO,
  LOADED_CAMPAIGNS,
  LOADED_CAMPAIGN_DETAIL
} from './types';

const SERVER_BASE_URL = "http://localhost:8090";

export const login = (user, password) => {
  const url = SERVER_BASE_URL + "/login?username=" + user + "&password=" + password; 
  return (dispatch) => {    
    axios.post(url)
    .then(data => { localStorage.setItem('TOKEN', data.data.token); dispatch({ type: LOGIN_OK })})
    .catch(err => dispatch({ type: LOGIN_KO }));
  };
};

export const loadCampaignsData = () => {
  const url = SERVER_BASE_URL + "/campaign"; 
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
  const url = SERVER_BASE_URL + "/campaign/" + campaignId; 
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


export const loadData = () => {
  return (dispatch) => {
  	dispatch({ type: RELOAD_DATA });
    fetch(SERVER_BASE_URL + "/campaign")
    .then(data => data.json())
    .then(data => {
      console.log(data);      
    });

  };
};

export const loadChildren = (childrenId) => {
  return (dispatch) => {  
    dispatch({ type: RELOAD_CHILDREN });
    loadChildrenElements(childrenId, dispatch);
  };
};

export const loadUser = (userId) => {
  return (dispatch) => {
    fetch('https://hacker-news.firebaseio.com/v0/user/'+userId+'.json?print=pretty')
    .then(data => data.json())
    .then(data => {
      dispatch({ type: LOAD_USER, payload: data });
    });

  };
};


function getElement(id, dispatch, type) {
  fetch('https://hacker-news.firebaseio.com/v0/item/'+id+'.json?print=pretty')
    .then(data => data.json())
    .then(data => {
      dispatch({ type, payload: data });
    });
}

function loadChildrenElements(childrenId, dispatch) {
  fetch('https://hacker-news.firebaseio.com/v0/item/'+childrenId+'.json?print=pretty')
    .then(data => data.json())
    .then(data => {
      console.log(data);
      if (data.kids) {
        data.kids.map(e => {
          loadChildrenElements(e, dispatch);
          getElement(e, dispatch, LOADED_CHILDREN);
        });
      }
    });
}