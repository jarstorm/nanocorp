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
	      	<div className="row">
	        	<Link className="pull-left" to="">Back</Link>	        
	        </div>
	        <div className="panel panel-default">
			  <div className="panel-heading">
			    <h3 className="panel-title">Campaign info</h3>
			  </div>
			  <div className="panel-body">
			    <p>Id: {data.id} </p>
	        	<p>Name: {data.name} </p>
	        	<p>Goal: {data.goal} </p>
	        	<p>Total budget: {data.totalBudget} </p>
			  </div>
			</div>	  			
	        {data.platforms.map((p) => <Platform key={p.id} data={p} />)}	        	        
	      </div>
	    )
  	}
}


function mapStateToProps({ campaign }) {  	
  return {data: campaign.detail};
}

export default connect(mapStateToProps, actions)(Detail);