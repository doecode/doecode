import React from 'react';
import {Modal,Button} from 'react-bootstrap';
import TextField  from './TextField';
import SelectField from './SelectField';
import {observer} from "mobx-react";

@observer
export default class AgentsModal extends React.Component {
  constructor(props) {
    super(props);
    this.open = this.open.bind(this);
    this.close = this.close.bind(this);
    this.onModalChange = this.onModalChange.bind(this);
    this.handleSave = this.handleSave.bind(this);
  }

  close() {
    this.props.store.showModal = false;
    this.props.store.clear();
  }

  open() {
    this.props.store.showModal = true;
    this.props.store.clear();

  }

  onModalChange(id,value) {
	  this.props.store.developer[id] = value;
	}

  handleSave(event) {
	  var dev = Object.assign({}, this.props.store.developer);
	  this.props.onClick(dev);
	  this.close();
  }

  render() {
    const developer = this.props.store.developer;
    const showModal = this.props.store.showModal;
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

        <Modal show={showModal} onHide={this.close} bsSize="large">
          <Modal.Header closeButton>
            <Modal.Title>Manage Developer</Modal.Title>
          </Modal.Header>
          <Modal.Body>
           <div className="container-fluid">
             <div className="form-horizontal">
           <TextField field="first_name" label="First Name" type="textarea" value={developer.first_name} onChange={this.onModalChange}/>
           <TextField field="middle_name" label="Middle Name" type="textarea" value={developer.middle_name} onChange={this.onModalChange}/>
           <TextField field="last_name" label="Last Name" type="textarea" value={developer.last_name} onChange={this.onModalChange}/>
           <TextField field="email" label="Email" type="textarea" value={developer.email} onChange={this.onModalChange}/>
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
