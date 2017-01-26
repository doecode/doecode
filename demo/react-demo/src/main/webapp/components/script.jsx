var React = require('react');
var ReactDOM = require('react-dom');
var Griddle = require('griddle-react');
var ReactBootstrap = require('react-bootstrap');
var utils = require('./utils.js');

class AgentsModal extends React.Component {
  constructor(props) {
    super(props);
    var developerObj = {first_name:'',
    middle_name: '',
  last_name: '',
email:''}
    this.state = {showModal: false, developer : developerObj};
    this.open = this.open.bind(this);
    this.close = this.close.bind(this);
    this.onModalChange = this.onModalChange.bind(this);
    this.handleSave = this.handleSave.bind(this);
  }

  close() {
    var newState = this.state;
    var developerObj = {first_name:'',
    middle_name: '',
  last_name: '',
email:''}
    newState.showModal=false;
    newState.developer = developerObj;
    this.setState(newState);
  }

  open() {
    var newState = this.state;
    newState.showModal=true;
    this.setState(newState);

  }
  
  onModalChange(id,value) {
	  var newState = this.state;
	  newState.developer[id] = value;
	  this.setState(newState);

	}
  
  handleSave(event) {
	  this.props.onClick(this.state.developer);
	  this.close();
  }

  render() {
    return (
      <div className="form-group form-group-sm">
      <div className="col-xs-offset-5">
        <ReactBootstrap.Button
          bsStyle="primary"
          bsSize="large"
          onClick={this.open}
        >
        Add Developer
        </ReactBootstrap.Button>

        <ReactBootstrap.Modal show={this.state.showModal} onHide={this.close} bsSize="large">
          <ReactBootstrap.Modal.Header closeButton>
            <ReactBootstrap.Modal.Title>Manage Developer</ReactBootstrap.Modal.Title>
          </ReactBootstrap.Modal.Header>
          <ReactBootstrap.Modal.Body>
           <div className="container-fluid">
             <div className="form-horizontal">
           <TextField field="first_name" label="First Name" type="textarea" value={this.state.developer.first_name} onChange={this.onModalChange}/>
           <TextField field="middle_name" label="Middle Name" type="textarea" value={this.state.developer.middle_name} onChange={this.onModalChange}/>
           <TextField field="last_name" label="Last Name" type="textarea" value={this.state.developer.last_name} onChange={this.onModalChange}/>
           <TextField field="email" label="Email" type="textarea" value={this.state.developer.email} onChange={this.onModalChange}/>
            </div>
         </div>
          </ReactBootstrap.Modal.Body>
          <ReactBootstrap.Modal.Footer>
            <ReactBootstrap.Button onClick={this.close}>Close</ReactBootstrap.Button>
            <ReactBootstrap.Button onClick={this.handleSave}>Save and close</ReactBootstrap.Button>
          </ReactBootstrap.Modal.Footer>
        </ReactBootstrap.Modal>
        </div>
      </div>
    );
  }
}
class AgentsTable extends React.Component {
  constructor(props) {
    super(props);
  }


  render() {
    return(
    	
<div className="form-group form-group-sm">
      <div className="col-sm-offset-2 col-sm-8">
        <h2>Developers</h2>
        <Griddle results = {this.props.value} />
      </div>
</div>
);
  }

}

class TextField extends React.Component {
  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);


  }

  handleChange(event) {
    this.props.onChange(this.props.field,event.target.value);
  }


  render() {
	  return(
      <div className="form-group form-group-sm row">
      <label className="col-xs-2 control-label">
        {this.props.label}
      </label>
      <div className="col-xs-4">
        <input type="text" name={this.props.field} id={this.props.field} className="form-control" value={this.props.value} onChange={this.handleChange} />
      </div>
    </div>);
  }

}

class SelectField extends React.Component {
	  constructor(props) {
	    super(props);

	    this.handleChange = this.handleChange.bind(this);


	  }

	  handleChange(event) {
	    this.props.onChange(this.props.field,event.target.value);
	  }

	  render() {
		  return(
	      <div className="form-group form-group-sm row">
	      <label className="col-xs-2 control-label">
	        {this.props.label}
	      </label>
	      <div className="col-xs-4">
	        <select name={this.props.field} id={this.props.field} className="form-control" value={this.props.value} onChange={this.handleChange} />
	      </div>
	    </div>);
	  }

	}

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
