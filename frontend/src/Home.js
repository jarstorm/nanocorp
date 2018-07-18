import React, {Component} from 'react';
import { Link } from "react-router-dom";
import * as actions from './action';
import { connect } from 'react-redux';
import Campaign from './components/Campaign';

class Home extends Component {
	componentDidMount() {
		this.props.loadData();
	}

  	render() {
  		const {data} = this.props;
	    return (
	      <div>
	        <h1>List of capmpaigns</h1>
	        {data.map((t) => <Campaign data={t} />)}
	        <Link to="/main">Main</Link>
	      </div>
	    )
  	}
}

function mapStateToProps({ main }) {
  console.log(main);
  return { data: main.data };
}

export default connect(mapStateToProps, actions)(Home);