import React from 'react';
import AgentsModal from './AgentsModal';
import AgentsTable from './AgentsTable';
import Developer from './Developer';
import {observer} from "mobx-react";


const developer = new Developer();

@observer
export default class AgentsStep extends React.Component {

	constructor(props) {
		    super(props);
		    this.isValidated = this._isValidated.bind(this);
		  }
	
	_isValidated() {
		this.props.handleSubmit();
		return true;
	}

	  render() {

		    return (
		    <div>
		      <AgentsTable value={this.props.developers}/>
		      <AgentsModal store={developer} onClick={this.props.onModalSubmit}/>
		    </div>
		      );
		  }
}
