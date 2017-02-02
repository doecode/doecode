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
    this.props.editDeveloper(gridRow.props.data);
  }

  render() {
    const configureMetadata = [{
    	    "columnName": "place",
    	    "order": 1,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "#"
    	  },{
    	    "columnName": "index",
    	    "order": 2,
    	    "locked": true,
    	    "visible": false
    	  },{
    	    "columnName": "first_name",
    	    "order": 3,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "First Name"
    	  },
    	  {
    	    "columnName": "middle_name",
    	    "order": 4,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Middle Name"

    	  },
    	  {
    	    "columnName": "last_name",
    	    "order": 5,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Last Name"
    	  },
    	  {
    	    "columnName": "email",
    	    "order": 6,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "Email"
    	  }]

        const columns = ["place", "first_name", "middle_name", "last_name", "email"];

	return(

<div className="form-group form-group-sm">
      <div className="col-sm-offset-1 col-sm-10">
        <h2 className="no-margin-left">Developers</h2>
        <Griddle results = {this.props.value} columnMetadata={configureMetadata} showSettings={true} showFilter={true} onRowClick={this.rowClick} columns={columns} />
      </div>
      <div className="col-sm-1">
      </div>
</div>
);
  }

}
