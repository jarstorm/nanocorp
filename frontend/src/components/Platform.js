import React, {Component} from 'react';
import Insights from './Insights';
import TargetAudience from './TargetAudience';
import Creative from './Creative';

export default class Platform extends Component {
  	render() {
	  	const {data} = this.props;
	    return (
	      <div>	      
	      	<div className="panel panel-default">
			  <div className="panel-heading">
			    <h3 className="panel-title">Platform <b>{data.platformType}</b></h3>
			  </div>
			  <div className="panel-body">
			    <p>Total budget: {data.totalBudget} </p>	        
	        	<p>Remaining budget: {data.remainingBudget} </p>	        
	        	<p>Status: {data.status} </p>	        	        	
	        	<Insights data={data.insights} />
	        	<TargetAudience data={data.targetAudience} />
	        	<Creative data={data.creative} />
			  </div>
			</div>	 	        	        
	      </div>
	    )
  	}
}
