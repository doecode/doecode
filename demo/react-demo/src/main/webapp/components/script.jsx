import React from 'react';
import ReactDOM from 'react-dom';
import {doAjax, appendQueryString} from './utils';
import TextField from './TextField';
import SelectField from './SelectField';
import AgentsStep from './AgentsStep';
import {observer} from "mobx-react";
import Metadata from './Metadata';
import MetadataStep from './MetadataStep';

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

    onModalSubmit(developer) {
        this.props.store.addToDevelopers(developer);
    }

    handleSubmit(event) {
        doAjax('POST', 'services?action=save', this.parseSaveResponse, this.props.store.metadata);
        event.preventDefault();
    }

    parseSaveResponse(data) {
        alert('Saved record');
        console.log(data);

    }

    render() {
        const metadata = store.metadata;
        return (
            <div className="container-fluid">
                <form id="react_form" className="form-horizontal" onSubmit={this.handleSubmit}>
                	<MetadataStep metadata={metadata} onMobxChange={this.onMobxChange}/>
                    <AgentsStep developers={metadata.developers.slice()} onModalSubmit={this.onModalSubmit}/>
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
