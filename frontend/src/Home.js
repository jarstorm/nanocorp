import React, {Component} from 'react';
import { Link } from "react-router-dom";
import * as actions from './action';
import { connect } from 'react-redux';
import Campaigns from './components/Campaigns';
import Login from './components/Login';

class Home extends Component {
  	render() {  		
  		const {logged} = this.props;  		
  		if (logged) {  			
		    return (
		      	<Campaigns />
		    )
		} else {
			return (
				<Login />
			)
		}
  	}
}

function mapStateToProps({ app }) {  	
  	return app;
}

export default connect(mapStateToProps, actions)(Home);