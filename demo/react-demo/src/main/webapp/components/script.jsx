const React = require('react');
const ReactDOM = require('react-dom');
const Griddle = require('griddle-react');
const ReactBootstrap = require('react-bootstrap');
const utils = require('./utils.js');
const TextField  = require('./TextField');
const SelectField = require('./SelectField');
const AgentsModal = require('./AgentsModal');
const AgentsTable = require('./AgentsTable');

class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {metadata : {
    	"code_id": undefined,
    	"site_ownership_code": undefined,
    	"open_source": undefined,
    	"repository_link": undefined,
    	"developers": [],
    	"originating_research_organizations": undefined,
    	"software_title": undefined,
    	"acronym": undefined,
    	"doi": undefined,
    	"description": undefined,
    	"related_identifiers": undefined,
    	"country_of_origin": undefined,
    	"keywords": undefined,
    	"disclaimers": undefined,
    	"license": undefined,
    	"recipient_name": undefined,
    	"recipient_email": undefined,
    	"recipient_phone": undefined,
    	"recipient_org": undefined,
    	"site_accession_number": undefined,
    	"other_special_requirements": undefined,
    	"related_software": undefined
    }
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.parseLoadResponse = this.parseLoadResponse.bind(this);
    this.parseSaveResponse = this.parseSaveResponse.bind(this);
    this.onStateChange = this.onStateChange.bind(this);
    this.onModalSubmit = this.onModalSubmit.bind(this);


  }

  componentWillMount() {
	    utils.doAjax('GET', 'services?action=load', this.parseLoadResponse);
  }


 parseLoadResponse(responseData) {
    this.setState({
    	metadata : responseData.metadata
    });
}

onStateChange(id,value) {
  var newState = this.state;
  newState.metadata[id] = value;
  this.setState(newState);

}

onModalSubmit(developer) {
	  var newState = this.state;
	  newState.metadata.developers.push(developer);
	  this.setState(newState);
}

  handleSubmit(event) {
	console.log(this.state.metadata);
    utils.doAjax('POST', 'services?action=save', this.parseSaveResponse, this.state.metadata);

    event.preventDefault();
  }

  parseSaveResponse(data) {
	  alert('Saved record');
  }

  render() {

    return (
      <div className="container-fluid">
      <form id="react_form" className="form-horizontal" onSubmit={this.handleSubmit}>
      <TextField field="software_title" label="Software Title" type="textarea" value={this.state.metadata.software_title} onChange={this.onStateChange}/>
      <TextField field="acronym" label="Acronym or Short Title" type="text" value={this.state.metadata.acronym} onChange={this.onStateChange}/>
      <TextField field="description" label="Software Title" type="textarea" value={this.state.metadata.description} onChange={this.onStateChange}/>
      <TextField field="disclaimers" label="Disclaimers" type="text" value={this.state.metadata.disclaimers} onChange={this.onStateChange}/>
      <TextField field="doi" label="DOI" type="text" value={this.state.metadata.doi} onChange={this.onStateChange}/>
      <TextField field="keywords" label="Keywords" type="text" value={this.state.metadata.keywords} onChange={this.onStateChange}/>
      <TextField field="license" label="License" type="select" value={this.state.metadata.license} onChange={this.onStateChange}/>
      <SelectField field="open_source" label="Open Source?" type="select" value={this.state.metadata.open_source} onChange={this.onStateChange}/>
      <TextField field="originating_research_organizations" label="Originating Research Organizations" type="text" value={this.state.metadata.originating_research_organizations} onChange={this.onStateChange}/>
      <TextField field="other_special_requirements" label="Other Special Requirements" type="text" value={this.state.metadata.other_special_requirements} onChange={this.onStateChange}/>
      <TextField field="recipient_email" label="Recipient Email" type="text" value={this.state.metadata.recipient_email} onChange={this.onStateChange}/>
      <TextField field="recipient_name" label="Recipient Name" type="text" value={this.state.metadata.recipient_name} onChange={this.onStateChange}/>
      <TextField field="recipient_org" label="Recipient Organization" type="text" value={this.state.metadata.recipient_org} onChange={this.onStateChange}/>
      <TextField field="recipient_phone" label="Recipient Phone Number" type="text" value={this.state.metadata.recipient_phone} onChange={this.onStateChange}/>
      <TextField field="related_identifiers" label="Related Identifiers" type="text" value={this.state.metadata.related_identifiers} onChange={this.onStateChange}/>
      <TextField field="related_software" label="Related Software" type="text" value={this.state.metadata.related_software} onChange={this.onStateChange}/>
      <TextField field="repository_link" label="Repository Link" type="text" value={this.state.metadata.repository_link} onChange={this.onStateChange}/>
      <TextField field="site_accession_number" label="Site Accession Number" type="text" value={this.state.metadata.site_accession_number} onChange={this.onStateChange}/>
      <SelectField field="site_ownership_code" label="Site Ownership Code" type="select" value={this.state.metadata.site_ownership_code} onChange={this.onStateChange}/>
      <AgentsTable value={this.state.metadata.developers}/>
      <AgentsModal onClick={this.onModalSubmit}/>
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
  <NameForm />,
  document.getElementById('root')
);
