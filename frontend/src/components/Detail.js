import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';
import { Link } from "react-router-dom";
import Platform from './Platform';

class Detail extends Component {
	componentDidMount() {	
		this.props.loadCampaign(this.props.match.params.campaignId);
	}

  	render() {
	  	const {data} = this.props;	  	
	    return (
	      <div>
	        <Link to="">Back</Link>
	        <p>Id: {data.id} </p>
	        <p>Name: {data.name} </p>
	        <p>Goal: {data.goal} </p>
	        <p>Total budget: {data.totalBudget} </p>
	        {data.platforms.map((p) => <Platform key={p.id} data={p} />)}	        
	      </div>
	    )
  	}
}


function mapStateToProps({ campaign }) {  	
  return {data: campaign.detail};
}

export default connect(mapStateToProps, actions)(Detail);