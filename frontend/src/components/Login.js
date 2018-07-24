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
  		const {error} = this.props;
	    return (
	      <div className="col-md-6 col-md-offset-3 login-container">  
	      	<div className="panel panel-default">
	      	  <div className="panel-heading">Login form</div>
				<div className="panel-body">
			  	<div className="col-md-12">
				    <label><b>Username</b></label>
				    <input type="text" className="form-control" placeholder="Enter Username" name="uname" required onChange={(e) => this._updateUserName(e)}/>
				</div>
				<div className="col-md-12">
				    <label><b>Password</b></label>
				    <input type="password" className="form-control" placeholder="Enter Password" name="psw" required onChange={(e) => this._updatePassword(e)}/>
				</div>
				<div className="col-md-12 login-button">
			    	<button type="button" className="btn btn-primary pull-right" onClick={() => this._handleLogin()}>Login</button>			    
			    </div>
			  </div>
			  <p className="error-text">{error}</p>			    		
		    </div>		    		    
	      </div>
	    )
  	}
}

function mapStateToProps({ app }) {  
  return app;
}

export default connect(mapStateToProps, actions)(Login);