import React from 'react';
import AgentsModal from './AgentsModal';
import AgentsTable from './AgentsTable';
import Developer from './Developer';
import {observer} from 'mobx-react';


const developerStore = new Developer();

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
		    const metadata = this.props.metadataStore.metadata;
		    return (
		    <div>
		      <AgentsTable developers={metadata.developers.slice()} developerStore={developerStore} />
		      <AgentsModal developerStore={developerStore} metadataStore={this.props.metadataStore}/>
		    </div>
		      );
		  }
}
