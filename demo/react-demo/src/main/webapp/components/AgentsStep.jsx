import React from 'react';
import AgentsModal from './AgentsModal';
import AgentsTable from './AgentsTable';
import Developer from './Developer';
import {observer} from 'mobx-react';
import Promise from 'promise';


const developerStore = new Developer();

@observer
export default class AgentsStep extends React.Component {

	constructor(props) {
		    super(props);
		    this.isValidated = this._isValidated.bind(this);
		  }

	_isValidated() {
		
		return new Promise((resolve,reject) => {
			   setTimeout(() => {

			        //this.props.updateStore({savedToCloud: true});  // Update store here (this is just an example, in reality you will do it via redux or flux)

			        // call resolve() to indicate that server validation or other aync method was a success.
			        // ... only then will it move to the next step. reject() will indicate a fail
			        //resolve();
			         reject(); // or reject
			      }, 5000);
		
		});
		
	}
	
	

	  render() {
		  
		    const metadata = this.props.metadataStore.metadata;
		    const developers = metadata.developers.slice();
		    const devsLength = developers.length;
		    return (
		    <div>
		      <AgentsTable developers={developers} developerStore={developerStore} />
		      <AgentsModal developerStore={developerStore} metadataStore={this.props.metadataStore} devsLength={devsLength} />
		    </div>
		      );
		  }
}
