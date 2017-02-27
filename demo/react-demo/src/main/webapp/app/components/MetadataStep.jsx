import React from 'react';
import TextField from './TextField';
import {observer} from "mobx-react";

@observer
export default class MetadataStep extends React.Component {

	constructor(props) {
		super(props);

		this.onFieldChange = this.onFieldChange.bind(this);
		this.isValidated = this._isValidated.bind(this);
	}

	_isValidated() {
		//adding validations later

		return true;
	}

    onFieldChange(id, value) {
        this.props.metadataStore.metadata[id] = value;
    }




	render() {
		const metadata = this.props.metadataStore.metadata;
		const finished = this.props.metadataStore.finished;
		
		const licenses = {
				"Select One" : "",
				"BSD 3-Clause" : "BSD 3-Clause",
				"GNU General Public License" : "GNU General Public License",
				"MIT License" : "MIT License"};
		
		return (
	            <div className="container-fluid">
                <form id="react_form" className="form-horizontal col-sm-offset-2 col-sm-8">
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="repository_link" label="Repository Link" elementType="input" value={metadata.repository_link} onChange={this.onFieldChange}/>
								{!finished &&
								<button className="btn btn-primary btn-sm" onClick={this.props.autopopulate}> Autopopulate </button>
								}
                </div>
                <hr></hr>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="software_title" label="Software Title" elementType="input" value={metadata.software_title} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="acronym" label="Acronym or Short Title" elementType="input" value={metadata.acronym} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="description" label="Description/Abstract" elementType="input" value={metadata.description} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="disclaimers" label="Disclaimers" elementType="input" value={metadata.disclaimers} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="doi" label="DOI" elementType="input" value={metadata.doi} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="keywords" label="Keywords" elementType="input" value={metadata.keywords} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField options={licenses} displayOnly={finished} field="license" label="License" elementType="select" value={metadata.license} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="originating_research_organizations" label="Originating Research Organizations" elementType="input" value={metadata.originating_research_organizations} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="other_special_requirements" label="Other Special Requirements" elementType="input" value={metadata.other_special_requirements} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="recipient_email" label="Recipient Email" elementType="input" value={metadata.recipient_email} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="recipient_name" label="Recipient Name" elementType="input" value={metadata.recipient_name} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="recipient_org" label="Recipient Organization" elementType="input" value={metadata.recipient_org} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="recipient_phone" label="Recipient Phone Number" elementType="input" value={metadata.recipient_phone} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="related_identifiers" label="Related Identifiers" elementType="input" value={metadata.related_identifiers} onChange={this.onFieldChange}/>
                </div>
                <div className="form-group form-group-sm row">
                <TextField displayOnly={finished} field="related_software" label="Related Software" elementType="input" value={metadata.related_software} onChange={this.onFieldChange}/>
                <TextField displayOnly={finished} field="site_accession_number" label="Site Accession Number" elementType="input" value={metadata.site_accession_number} onChange={this.onFieldChange}/>
                </div>
                </form>
                </div>
		);
	}




}
