import React, {Component} from 'react';

export default class Insights extends Component {
  	render() {
	  	const {data} = this.props;
	  	if (data !== null) {
	    return (
	      <div>	  
	      	<p><b>Insights</b></p>    
	      	<p>Clicks: {data.clicks}</p>
	      	<p>Clicks through rate: {data.clicksThroughRate}</p>
	      	<p>Cost per click: {data.costPerClick}</p>
	      	<p>Impressions: {data.impressions}</p>
	      	<p>Kpi1: {data.kpi1}</p>
	      	<p>Kpi2: {data.kpi2}</p>
	      	<p>Nanos score: {data.nanosScore}</p>
	      	<p>Website visits: {data.websiteVisits}</p>
	      </div>
	    )
	} else {
		return (<div><p><b>Insights</b></p></div>)
	}
  	}
}
