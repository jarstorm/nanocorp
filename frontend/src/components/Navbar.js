import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';
import { Link } from "react-router-dom";
import Platform from './Platform';

class Navbar extends Component {

	_logout = () => {
		this.props.logout();	
	}

	_printLoginInfo = () => {
		if (this.props.logged) {
			return (
				<li><a href="/" onClick={() => this._logout()}>Logout</a></li>
			)
		} 
	}

  	render() {	  	
	    return (
	      <nav className="navbar navbar-default">
          	<div className="container-fluid">
              <ul className="nav navbar-nav">
              <li><a className="navbar-brand" href="#">
                <p>Nanocorp</p>
              </a></li>
              </ul>
              <ul className="nav navbar-nav navbar-right">
              	{this._printLoginInfo()}
              </ul>            
          	</div>
        </nav>
	    )
  	}
}


function mapStateToProps({ app }) {  	
  return app;
}

export default connect(mapStateToProps, actions)(Navbar);