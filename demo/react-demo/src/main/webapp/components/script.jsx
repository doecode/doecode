import React from 'react';
import ReactDOM from 'react-dom';
import {doAjax, appendQueryString} from './utils';
import {observer} from "mobx-react";
import Metadata from './Metadata';
import AgentsStep from './AgentsStep';
import MetadataStep from './MetadataStep';
import ConfirmStep from './ConfirmStep';
import StepZilla from 'react-stepzilla';

const metadataStore = new Metadata();

@observer
class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.parseLoadResponse = this.parseLoadResponse.bind(this);
        this.parseSaveResponse = this.parseSaveResponse.bind(this);
        this.autopopulate = this.autopopulate.bind(this);
    }

    autopopulate(event) {
    	doAjax('GET', "services/react?action=autopopulate&repo=" + this.props.store.metadata.repository_link,this.parseLoadResponse);
    	event.preventDefault();
    }


    parseLoadResponse(responseData) {
        this.props.metadataStore.metadata = responseData.metadata;
    }


    handleSubmit() {
        doAjax('POST', 'services/react?action=save', this.parseSaveResponse, this.props.store.metadata);
    }

    parseSaveResponse(data) {
        alert('Saved record');
        console.log(data);

    }

    render() {
        const metadata = metadataStore.metadata;
        const steps =
        	[
        		{name: 'Metadata', component: <MetadataStep metadataStore={metadataStore}  autopopulate={this.autopopulate}/> },
        		{name: 'Developers', component: <AgentsStep metadataStore={metadataStore} handleSubmit={this.handleSubmit}/>},
        		{name: 'Confirmation', component: <ConfirmStep /> }
        		];
        return (


            <div className='step-progress'>
            	<StepZilla steps={steps} nextTextOnFinalAction={"Submit"}/>
            </div>
        );
    }
}

ReactDOM.render(
    <NameForm metadataStore={metadataStore}/>, document.getElementById('root'));
