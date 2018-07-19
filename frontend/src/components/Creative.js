import React, {Component} from 'react';
import {SERVER_URL} from '../../config.js';

export default class Creative extends Component {
  	render() {
	  	const {data} = this.props;
	  	if (data !== null) {
	    return (	    		
	      <div>	
	      	<p><b>Creative</b></p>      
	      	<p>Description: {data.description}</p>
	      	<p>Header: {data.header}</p>
	      	<p>Header1: {data.header1}</p>
	      	<p>header2: {data.header2}</p>
	      	<p>Image: </p><img src={SERVER_URL + "/images/" + data.image} />
	      	<p>Url: {data.url}</p>
	      </div>
	    )
	} else {
		return (<div><p><b>Creative</b></p></div>)
	}
  	}
}
