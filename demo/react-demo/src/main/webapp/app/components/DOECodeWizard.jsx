import React from 'react';
import ReactDOM from 'react-dom';
import {doAjax, appendQueryString} from '../utils/utils';
import {observer} from "mobx-react";
import Metadata from '../stores/Metadata';
import AgentsStep from './AgentsStep';
import MetadataStep from './MetadataStep';
import AccessStep from './AccessStep';
import ConfirmStep from './ConfirmStep';
import StepZilla from 'react-stepzilla';

import css from '../css/main.css';

const metadataStore = new Metadata();

@observer
export default class DOECodeWizard extends React.Component {
    constructor(props) {
        super(props);
        this.getSubmitPromise = this.getSubmitPromise.bind(this);
        this.parseLoadResponse = this.parseLoadResponse.bind(this);
        this.autopopulate = this.autopopulate.bind(this);
    }

    autopopulate(event) {
    	doAjax('GET', "/api/metadata/autopopulate?repo=" + metadataStore.metadata.repository_link,this.parseLoadResponse);
    	event.preventDefault();
    }


    parseLoadResponse(responseData) {
        metadataStore.updateMetadata(responseData.metadata);
    }

    getSubmitPromise() {
      var self = this;
		return new Promise((resolve,reject) => {
		    $.ajax({
		        url: "/api/metadata",
		        cache: false,
		        method: 'POST',
		        dataType: 'json',
		        data: JSON.stringify(metadataStore.metadata),
		        contentType: "application/json; charset=utf-8",
		        success: function(data) {
		        	console.log(data);
                    metadataStore.finished = true;
                    metadataStore.metadata.code_id = data.metadata.code_id;
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
        const finished = metadataStore.finished;

        const steps =
        	[
        		{name: 'Metadata', component: <MetadataStep metadataStore={metadataStore}  autopopulate={this.autopopulate}/> },
        		{name: 'Licenses & Access Limitations', component: <AccessStep metadataStore={metadataStore}/>},
        		{name: 'Developers', component: <AgentsStep metadataStore={metadataStore} getSubmitPromise={this.getSubmitPromise}/>},
        		{name: 'Confirmation', component: <ConfirmStep metadataStore={metadataStore}/> }
        		];
        return (


            <div className='step-progress'>
            	<StepZilla steps={steps} dontValidate={false} preventEnterSubmission={true} prevBtnOnLastStep={false} stepsNavigation={false} nextTextOnFinalAction={"Submit"}/>
            </div>
        );
    }
}

