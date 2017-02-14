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
        this.getSubmitPromise = this.getSubmitPromise.bind(this);
        this.parseLoadResponse = this.parseLoadResponse.bind(this);
        this.autopopulate = this.autopopulate.bind(this);
    }

    autopopulate(event) {
    	doAjax('GET', "services/react?action=autopopulate&repo=" + this.props.metadataStore.metadata.repository_link,this.parseLoadResponse);
    	event.preventDefault();
    }


    parseLoadResponse(responseData) {
        this.props.metadataStore.updateMetadata(responseData.metadata);
    }

    getSubmitPromise() {
      var self = this;
		return new Promise((resolve,reject) => {
		    $.ajax({
		        url: 'services/react?action=save',
		        cache: false,
		        method: 'POST',
		        dataType: 'json',
		        data: JSON.stringify(this.props.metadataStore.metadata),
		        contentType: "application/json; charset=utf-8",
		        success: function(data) {
		        	console.log(data);
              self.props.metadataStore.finished = true;
              self.props.metadataStore.metadata.code_id = data.metadata.code_id;
		        	resolve();

		        },
		        error: function(x,y,z) {
		        	console.log("got an error");
		        	reject();
		        }
		      });

		});
    }

    render() {
        const finished = this.props.metadataStore.finished;

        const steps =
        	[
        		{name: 'Metadata', component: <MetadataStep metadataStore={this.props.metadataStore}  autopopulate={this.autopopulate}/> },
        		{name: 'Developers', component: <AgentsStep metadataStore={this.props.metadataStore} getSubmitPromise={this.getSubmitPromise}/>},
        		{name: 'Confirmation', component: <ConfirmStep metadataStore={this.props.metadataStore}/> }
        		];
        return (


            <div className='step-progress'>
            	<StepZilla steps={steps} dontValidate={false} preventEnterSubmission={true} prevBtnOnLastStep={false} stepsNavigation={false} nextTextOnFinalAction={"Submit"}/>
            </div>
        );
    }
}

ReactDOM.render(
    <NameForm metadataStore={metadataStore}/>, document.getElementById('root'));
