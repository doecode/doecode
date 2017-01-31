import React from 'react';
import ReactDOM from 'react-dom';
import {doAjax, appendQueryString} from './utils';
import TextField from './TextField';
import SelectField from './SelectField';
import AgentsStep from './AgentsStep';
import {observer} from "mobx-react";
import Metadata from './Metadata';

const store = new Metadata();

@observer
class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.parseLoadResponse = this.parseLoadResponse.bind(this);
        this.parseSaveResponse = this.parseSaveResponse.bind(this);
        this.onModxChange = this.onModxChange.bind(this);
        this.onModalSubmit = this.onModalSubmit.bind(this);
    }

    componentWillMount() {
        doAjax('GET', 'services?action=load', this.parseLoadResponse);
    }

    parseLoadResponse(responseData) {
        this.setState({metadata: responseData.metadata});
    }

    onModxChange(id, value) {
        this.props.store.metadata[id] = value;
    }

    onModalSubmit(developer) {
        this.props.store.addToDevelopers(developer);
    }

    handleSubmit(event) {
        console.log(this.props.store.metadata);
        doAjax('POST', 'services?action=save', this.parseSaveResponse, this.props.store.metadata);

        event.preventDefault();
    }

    parseSaveResponse(data) {
        alert('Saved record');
        console.log(data);

    }

    render() {
        const store = this.props.store;
        const metadata = store.metadata;
        console.log(metadata);
        return (
            <div className="container-fluid">
                <form id="react_form" className="form-horizontal" onSubmit={this.handleSubmit}>
                    <TextField field="software_title" label="Software Title" type="textarea" value={metadata.software_title} onChange={this.onModxChange}/>
                    <TextField field="acronym" label="Acronym or Short Title" type="text" value={metadata.acronym} onChange={this.onModxChange}/>
                    <TextField field="description" label="Software Title" type="textarea" value={metadata.description} onChange={this.onModxChange}/>
                    <TextField field="disclaimers" label="Disclaimers" type="text" value={metadata.disclaimers} onChange={this.onModxChange}/>
                    <TextField field="doi" label="DOI" type="text" value={metadata.doi} onChange={this.onModxChange}/>
                    <TextField field="keywords" label="Keywords" type="text" value={metadata.keywords} onChange={this.onModxChange}/>
                    <TextField field="license" label="License" type="select" value={metadata.license} onChange={this.onModxChange}/>
                    <TextField field="originating_research_organizations" label="Originating Research Organizations" type="text" value={metadata.originating_research_organizations} onChange={this.onModxChange}/>
                    <TextField field="other_special_requirements" label="Other Special Requirements" type="text" value={metadata.other_special_requirements} onChange={this.onModxChange}/>
                    <TextField field="recipient_email" label="Recipient Email" type="text" value={metadata.recipient_email} onChange={this.onModxChange}/>
                    <TextField field="recipient_name" label="Recipient Name" type="text" value={metadata.recipient_name} onChange={this.onModxChange}/>
                    <TextField field="recipient_org" label="Recipient Organization" type="text" value={metadata.recipient_org} onChange={this.onModxChange}/>
                    <TextField field="recipient_phone" label="Recipient Phone Number" type="text" value={metadata.recipient_phone} onChange={this.onModxChange}/>
                    <TextField field="related_identifiers" label="Related Identifiers" type="text" value={metadata.related_identifiers} onChange={this.onModxChange}/>
                    <TextField field="related_software" label="Related Software" type="text" value={metadata.related_software} onChange={this.onModxChange}/>
                    <TextField field="repository_link" label="Repository Link" type="text" value={metadata.repository_link} onChange={this.onModxChange}/>
                    <TextField field="site_accession_number" label="Site Accession Number" type="text" value={metadata.site_accession_number} onChange={this.onModxChange}/>
                    <AgentsStep developers={store.developers} onModalSubmit={this.onModalSubmit}/>
                    <div className="form-group form-group-sm">
                        <div className="col-xs-offset-2">
                            <button className="btn btn-primary" type="submit">
                                Submit
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}

ReactDOM.render(
    <NameForm store={store}/>, document.getElementById('root'));
