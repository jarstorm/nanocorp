import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';
import Campaign from './Campaign';

class CampaignList extends Component {
	componentDidMount() {
		this.props.loadCampaignsData();
	}

  	render() {
  		const {data} = this.props;
	    return (
	      <div>
	      	<div className="panel panel-default">
			  <div className="panel-heading">
			    <h3 className="panel-title">Campaign list</h3>
			  </div>
			  <div className="panel-body">
			    {data.map((c) => <Campaign key={c.id} data={c} />)}
			  </div>
			</div>	      	
	      </div>
	    )
  	}
}

function mapStateToProps({ campaign }) {  	
  return {data: campaign.data};
}

export default connect(mapStateToProps, actions)(CampaignList);