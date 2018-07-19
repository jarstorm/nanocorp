import React, {Component} from 'react';
import * as actions from '../action';
import { connect } from 'react-redux';

class Detail extends Component {
	componentDidMount() {	
		this.props.loadCampaign(this.props.match.params.campaignId);
	}

  render() {
  	const {data} = this.props;
    return (
      <div>
        <p>Id {data.id} </p>
        <p>Name {data.name} </p>
        <p>Goal {data.goal} </p>
      </div>
    )
  }
}


function mapStateToProps({ campaign }) {  	
  return {data: campaign.detail};
}

export default connect(mapStateToProps, actions)(Detail);