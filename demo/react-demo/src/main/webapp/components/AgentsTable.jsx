import React from 'react';
import Griddle from 'griddle-react';
import {observer} from "mobx-react";

@observer
export default class AgentsTable extends React.Component {
  constructor(props) {
    super(props);
    this.rowClick = this.rowClick.bind(this);
  }

  
  rowClick(gridRow, event) {
	  console.log(gridRow.props);
  }

  render() {
    const configureMetadata = [{
    	    "columnName": "first_name",
    	    "order": 1,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "First Name"
    	  },
    	  {
    	    "columnName": "middle_name",
    	    "order": 2,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Middle Name"
    	    
    	  },
    	  {
    	    "columnName": "last_name",
    	    "order": 3,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Last Name"
    	  },
    	  {
    	    "columnName": "email",
    	    "order": 4,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Email"
    	  }]
	  
	return(

<div className="form-group form-group-sm">
      <div className="col-sm-offset-1 col-sm-10">
        <h2 className="no-margin-left">Developers</h2>
        <Griddle results = {this.props.value} columnMetadata={configureMetadata} showSettings={true} showFilter={true} onRowClick={this.rowClick} />
      </div>
      <div className="col-sm-1">
      </div>
</div>
);
  }

}
