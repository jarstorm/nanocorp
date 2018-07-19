import React, {Component} from 'react';
import { Link } from "react-router-dom";

export default class Campaign extends Component {
  	render() {
	    return (
	      <div>        
	        <Link to={"/detail/" + this.props.data.id}>{this.props.data.name}</Link>
	      </div>
	    )
  	}
}

