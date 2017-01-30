const React = require('react');
const AgentsModal = require('./AgentsModal');
const AgentsTable = require('./AgentsTable');


class AgentsStep extends React.Component {
	  
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

module.exports = AgentsStep;