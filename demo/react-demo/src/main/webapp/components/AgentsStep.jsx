import React from 'react';
import AgentsModal from './AgentsModal';
import AgentsTable from './AgentsTable';
import Developer from './Developer';
import {observer} from 'mobx-react';
import PlaceModal from './PlaceModal';


const developerStore = new Developer();

@observer
export default class AgentsStep extends React.Component {

	constructor(props) {
		    super(props);
		    this.isValidated = this._isValidated.bind(this);
			this.editDeveloper = this.editDeveloper.bind(this);
		  }

	_isValidated() {
		this.props.handleSubmit();
		return true;
	}
	
	
	editDeveloper(dev) {
	   developerStore.developer = Object.assign({}, dev);
	   developerStore.previousPlace = dev.place;
	   developerStore.showModal = true;
	   developerStore.isEdit = true;
	}

	  render() {

		    return (
		    <div>
		      <AgentsTable value={this.props.developers} editDeveloper={this.editDeveloper} />
		      <AgentsModal store={developerStore} onClick={this.props.onModalSubmit}/>
		      <PlaceModal store={developerStore}/>
		    </div>
		      );
		  }
}
