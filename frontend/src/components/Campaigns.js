import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';
import Campaign from './Campaign';

class Campaigns extends Component {
	componentDidMount() {
		this.props.loadCampaignsData();
	}

  	render() {
  		const {data} = this.props;
	    return (
	      <div>
	        <h1>List of capmpaigns</h1>
	        {data.map((t) => <Campaign data={t} />)}	        
	      </div>
	    )
  	}
}

function mapStateToProps({ campaign }) {  	
  return {data: campaign.data};
}

export default connect(mapStateToProps, actions)(Campaigns);