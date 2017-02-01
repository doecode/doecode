import React from 'react';
import Griddle from 'griddle-react';
import {observer} from "mobx-react";

@observer
export default class AgentsTable extends React.Component {
  constructor(props) {
    super(props);
  }


  render() {
    return(

<div className="form-group form-group-sm">
      <div className="col-sm-offset-1 col-sm-10">
        <h2 className="no-margin-left">Developers</h2>
        <Griddle results = {this.props.value} />
      </div>
      <div className="col-sm-1">
      </div>
</div>
);
  }

}
