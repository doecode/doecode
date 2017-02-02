import React from 'react';
import ReactDOM from 'react-dom';
import {doAjax, appendQueryString} from './utils';
import {observer} from "mobx-react";
import Metadata from './Metadata';
import AgentsStep from './AgentsStep';
import MetadataStep from './MetadataStep';
import ConfirmStep from './ConfirmStep';
import StepZilla from 'react-stepzilla';

const store = new Metadata();

@observer
class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.parseLoadResponse = this.parseLoadResponse.bind(this);
        this.parseSaveResponse = this.parseSaveResponse.bind(this);
        this.onMobxChange = this.onMobxChange.bind(this);
        this.onModalSubmit = this.onModalSubmit.bind(this);
        this.onPlaceModalSubmit = this.onPlaceModalSubmit.bind(this);
    }

    componentWillMount() {
        doAjax('GET', 'services?action=load', this.parseLoadResponse);
    }

    parseLoadResponse(responseData) {
        this.props.store.metadata = responseData.metadata;
    }

    onMobxChange(id, value) {
        this.props.store.metadata[id] = value;
    }

    onModalSubmit(developer, saveType, previousPlace) {
    	if (saveType === "new") {
            this.props.store.addToDevelopers(developer);
    	} else if (saveType === "edit") {
        	this.props.store.modifyDeveloper(developer, previousPlace);
    	} else if (saveType === "remove") {
    		this.props.store.removeDeveloper(developer);
    	}
    }
    
    onPlaceModalSubmit(developer,previousPlace) {
    	this.props.store.updateDeveloperPlace(developer,previousPlace);
    }

    handleSubmit() {
        doAjax('POST', 'services?action=save', this.parseSaveResponse, this.props.store.metadata);
    }

    parseSaveResponse(data) {
        alert('Saved record');
        console.log(data);

    }

    render() {
        const metadata = store.metadata;
        
        const steps =
        	[
        		{name: 'Metadata', component: <MetadataStep metadata={metadata} onMobxChange={this.onMobxChange}/> },
        		{name: 'Developers', component: <AgentsStep developers={metadata.developers.slice()} onModalSubmit={this.onModalSubmit} handleSubmit={this.handleSubmit}/>},		
        		{name: 'Confirmation', component: <ConfirmStep /> }
        		]
        return (
        		
        		
            <div className='step-progress'>
            	<StepZilla steps={steps} nextTextOnFinalAction={"Submit"}/>
            </div>
        );
    }
}

ReactDOM.render(
    <NameForm store={store}/>, document.getElementById('root'));
