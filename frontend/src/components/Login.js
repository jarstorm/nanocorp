import React, {Component} from 'react';
import { Link } from "react-router-dom";
import * as actions from '../action';
import { connect } from 'react-redux';

class Login extends Component {
	constructor(props) {
    	super(props);
    	this.state = {userName: '', password: ''};
	}

	_updateUserName = (e) => {
		this.setState({userName: e.target.value});
	}

	_updatePassword = (e) => {
		this.setState({password: e.target.value});
	}

	_handleLogin = () => {				
		this.props.login(this.state.userName, this.state.password);
	}

  	render() {
  		//const {data} = this.props;
	    return (
	      <div>	        			  
			  <div className="container">
			    <label><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" name="uname" required onChange={(e) => this._updateUserName(e)}/>

			    <label><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="psw" required onChange={(e) => this._updatePassword(e)}/>

			    <button type="button" onClick={() => this._handleLogin()}>Login</button>			    
			  </div>			  
	      </div>
	    )
  	}
}

function mapStateToProps({ campaign }) {  
  return { data: campaign.data };
}

export default connect(mapStateToProps, actions)(Login);