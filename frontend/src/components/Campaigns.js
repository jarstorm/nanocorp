import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';
import Campaign from './Campaign';

class Campaigns extends Component {
	componentDidMount() {
		this.props.loadCampaignsData();
	}

	_logout = () => {
		this.props.logout();	
	}

  	render() {
  		const {data} = this.props;
	    return (
	      <div>
	      	<button onClick={() => this._logout()}>Logout</button>
	        <h1>List of capmpaigns</h1>
	        {data.map((c) => <Campaign key={c.id} data={c} />)}	        
	      </div>
	    )
  	}
}

function mapStateToProps({ campaign }) {  	
  return {data: campaign.data};
}

export default connect(mapStateToProps, actions)(Campaigns);