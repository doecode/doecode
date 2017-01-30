import React from 'react';
import {Modal,Button} from 'react-bootstrap';
import TextField  from './TextField';
import SelectField from './SelectField';

export default class AgentsModal extends React.Component {
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
        <Button
          bsStyle="primary"
          bsSize="large"
          onClick={this.open}
        >
        Add Developer
        </Button>

        <Modal show={this.state.showModal} onHide={this.close} bsSize="large">
          <Modal.Header closeButton>
            <Modal.Title>Manage Developer</Modal.Title>
          </Modal.Header>
          <Modal.Body>
           <div className="container-fluid">
             <div className="form-horizontal">
           <TextField field="first_name" label="First Name" type="textarea" value={this.state.developer.first_name} onChange={this.onModalChange}/>
           <TextField field="middle_name" label="Middle Name" type="textarea" value={this.state.developer.middle_name} onChange={this.onModalChange}/>
           <TextField field="last_name" label="Last Name" type="textarea" value={this.state.developer.last_name} onChange={this.onModalChange}/>
           <TextField field="email" label="Email" type="textarea" value={this.state.developer.email} onChange={this.onModalChange}/>
            </div>
         </div>
          </Modal.Body>
          <Modal.Footer>
            <Button onClick={this.close}>Close</Button>
            <Button onClick={this.handleSave}>Save and close</Button>
          </Modal.Footer>
        </Modal>
        </div>
      </div>
    );
  }
}

