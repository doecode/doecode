import React from 'react';
import ReactDOM from 'react-dom';
import {Modal, Button} from 'react-bootstrap';

class Splash extends React.Component {
    constructor(props) {
        super(props);
        this.state = {showModal: false};
        this.deposit = this.deposit.bind(this);
        this.open = this.open.bind(this);
        this.close = this.close.bind(this);
    }

    deposit() {
        window.location.href = 'index.html';
    }

    open() {
      this.setState({showModal:true});
    }

    close() {
        this.setState({showModal:false});
    }

    render() {

        return (
            <div className="container-fluid">
                <div className="row">
                    <div className="col-sm-offset-3 col-sm-3">
                        <a href="#" className="thumbnail" onClick={this.deposit}>
                            <div className="caption">
                                <h2>
                                    Add Your Project
                                </h2>
                            </div>
                        </a>
                    </div>
                    <div className="col-sm-3">
                        <a href="#" className="thumbnail" onClick={this.open}>
                            <div className="caption">
                                <h2>
                                    Create a Repository
                                </h2>
                            </div>
                        </a>
                    </div>
                </div>
                <Modal show={this.state.showModal} onHide={this.close} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title>Create a New Repository</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <h3> Gitlab or Github/Bitbucket? </h3>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.close}>Close</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }
}

ReactDOM.render(
    <Splash/>, document.getElementById('root'));
