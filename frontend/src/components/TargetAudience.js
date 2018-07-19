import React, {Component} from 'react';

export default class TargetAudience extends Component {
  	render() {
	  	const {data} = this.props;
	  	if (data !== null) {
	    return (
	      <div>	     
	      	<p><b>Target audience</b></p> 
	      	<p>Age min: {data.ageMin}</p>
	      	<p>Age max: {data.ageMax}</p>
	      	<p>Genders: </p>
	      	<ul>{data.genders.map(gender => <li key={gender}>{gender}</li>)}</ul>
	      	<p>Interests: </p>
	      	<ul>{data.interests.map(interest => <li key={interest}>{interest}</li>)}</ul>
	      	<p>Keywords: </p>
	      	<ul>{data.keywords.map(keyword => <li key={keyword}>{keyword}</li>)}</ul>
	      	<p>Languages: </p>
	      	<ul>{data.languages.map(language => <li key={language}>{language}</li>)}</ul>
	      	<p>Locations: </p>
	      	<ul>{data.locations.map(location => <li key={location}>{location}</li>)}</ul>
	      </div>
	    )
	} else {
		return (<div><p><b>Target audience</b></p> </div>)
	}
  	}
}
