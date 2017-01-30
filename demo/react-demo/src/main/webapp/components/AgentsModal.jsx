const React = require('react');
const ReactBootstrap = require('react-bootstrap');
const TextField  = require('./TextField');
const SelectField = require('./SelectField');

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

module.exports = AgentsModal;
