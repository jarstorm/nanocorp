import React, {Component} from 'react';
import {SERVER_URL} from '../../config.js';

export default class Creative extends Component {
  	render() {
	  	const {data} = this.props;
	  	if (data !== null) {
		    return (	    		
		      <div className="col-md-4">	
		      	<p><b>Creative</b></p>      
		      	<p>Description: {data.description}</p>
		      	<p>Header: {data.header}</p>
		      	<p>Header1: {data.header1}</p>
		      	<p>Header2: {data.header2}</p>
		      	<p>Url: {data.url}</p>
		      	<p>Image: </p><img src={SERVER_URL + "/image/" + data.image} className="creative-img"/>
		      </div>
		    )
		} else {
			return (<div><p><b>Creative</b></p></div>)
		}
  	}
}
