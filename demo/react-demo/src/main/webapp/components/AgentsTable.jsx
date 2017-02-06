import React from 'react';
import Griddle from 'griddle-react';
import {observer} from 'mobx-react';

@observer
export default class AgentsTable extends React.Component {
  constructor(props) {
    super(props);
    this.rowClick = this.rowClick.bind(this);
  }


  rowClick(gridRow, event) {
	  var dev = Object.assign({},gridRow.props.data);
	  //var dev = gridRow.props.data;
	  this.props.developerStore.developer = dev;
	  this.props.developerStore.previousPlace = dev.place;
	  this.props.developerStore.showModal = true;
	  this.props.developerStore.isEdit = true;
		
  }

  render() {
    const configureMetadata = [{
    	    "columnName": "place",
    	    "order": 1,
    	    "locked": false,
    	    "visible": true,
    	    "displayName": "#"
    	    
    	  },
    	  {
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
    	  }, 
    	  {
      	    "columnName": "affiliations",
      	    "order": 7,
      	    "locked": false,
      	    "visible": true,
      	    "displayName": "Affiliations"
      	  }]

        const columns = ["place", "first_name", "middle_name", "last_name", "email", "affiliations"];

	return(

<div className="form-group form-group-sm col-sm-12">
      <div className="col-sm-offset-1 col-sm-10">
        <h2 className="no-margin-left">Developers</h2>
        <Griddle results = {this.props.developers} columns={columns} columnMetadata={configureMetadata} showSettings={true} showFilter={true} onRowClick={this.rowClick} />
      </div>
</div>
);
  }

}
