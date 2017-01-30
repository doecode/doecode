import React from 'react';
import AgentsModal from './AgentsModal';
import AgentsTable from './AgentsTable';


export default class AgentsStep extends React.Component {
	  
	constructor(props) {
		    super(props);
		  }
	
	  render() {

		    return (
		    <div>
		      <AgentsTable value={this.props.developers}/>
		      <AgentsModal onClick={this.props.onModalSubmit}/>
		      <div className="form-group form-group-sm">
		        <div className="col-xs-offset-2">
		          <button className="btn btn-primary" type="submit">
		            Submit
		          </button>
		        </div>
		      </div>
		    </div>
		      );
		  }
}
