import React from 'react';
import ReactDOM from 'react-dom';
import {Modal, Button} from 'react-bootstrap';

export default class Splash extends React.Component {
    constructor(props) {
        super(props);
        this.state = {showModal: false};
        this.deposit = this.deposit.bind(this);
        this.open = this.open.bind(this);
        this.close = this.close.bind(this);
    }

    deposit() {
        window.location.href = 'wizard.html';
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
            <div className="col-xs-12">
            <p>The Department of Energy (DOE) Office of Scientific and Technical Information (OSTI) is building a new DOE software center.</p>

            <p>DOE Code is the reimagining of OSTI's current product for the submission of software, the Energy Science and Technology Software Center,
             or <a href="//www.osti.gov/moved/estsc/">ESTSC</a>.  Since DOE Code is still under development, if you need to submit, search, or order software, please visit the ESTSC site for instructions.</p>
            
            <p>DOE Code, when launched, will provide a best-in-class service for the submission of software. As a form of scientific and technical information,
             software is a result of the Department's research and development activities at the DOE national laboratories and other DOE facilities/contractors.</p>
             
            <p>DOE Code will provide <a href="https://www.osti.gov/ostiblog/osti-developing-open-source-social-coding-platform-doe-scientific-software">an open source, social platform for DOE scientific software</a>.  DOE Code will connect to repositories
             on GitHub, Bitbucket, and others, but will also provide a place to host code for users that are unable to use other hosting services.  Since DOE Code
             is itself an open source product, other institutions will be able to download and deploy it for their own purposes too. You
             can follow DOE Code’s development at the <a href="https://github.com/doecode">DOE Code GitHub site.</a></p>
            
            <p>To provide a new, modern way of interacting, DOE Code will not only provide the ability to link to references (papers, datasets) but also to other
             documents, manuals, examples, charts, forums, etc., in one place. All of this scientific and technical information will be linked to scientific software,
             whether it be software for modeling and simulation, data analytics or instrument control.</p>
            
            <p>The current software center, ESTSC, contains over 3,500 distinct pieces of software resulting from DOE R&amp;D, as well as selected software from the
             Nuclear Energy Agency of the Organization for Economic Cooperation and Development.  ESTSC is the centralized DOE software management portal.  The
             ESTSC portal provides access to software packages, including source code, executable object code, and the minimum support documentation (e.g.,
             software user guide or manual) needed to use the software or to modify the software to support subsequent development efforts.</p>
            
            <p>ESTSC and DOE Code are managed and operated by DOE OSTI.</p>
            </div>

                <Modal show={this.state.showModal} onHide={this.close} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title>Create a New Repository</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <div className="row">
                        <div className="col-sm-5">
                        Create a new project as part of one of our open source communities below:
                        <ul>
                        <li><a href="https://github.com/doecode/">GitHub</a> </li>
                        </ul>
                        </div>
                        <div className="col-sm-2">
                        <h1> OR </h1>
                        </div>
                        <div className="col-sm-5">
                        Create a new project on our internal <a href="http://lxdevrepo.osti.gov/">DOE Code repository</a> where you can
                        control access to the project.
                        </div>
                        </div>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.close}>Close</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }
}

