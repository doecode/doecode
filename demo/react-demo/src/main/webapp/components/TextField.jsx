import React from 'react';

export default class TextField extends React.Component {
  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);


  }

  handleChange(event) {
    this.props.onChange(this.props.field,event.target.value);
  }



  render() {
	  let input = null;
	  const elementType = this.props.elementType;

	  const labelStyle = this.props.labelStyle != undefined ? this.props.labelStyle : "col-sm-2 control-label";
	  const divStyle = this.props.labelStyle != undefined ? this.props.labelStyle : "col-sm-4";

	  if (this.props.displayOnly) {
		  input = this.props.value;
	  }
	  else if (elementType === 'input') {
		input = <input type="text" className="form-control" value={this.props.value} onChange={this.handleChange} />
	  } else if (elementType === 'select') {
		 const options = this.props.options;
	     input = <select className="form-control" value={this.props.value} onChange={this.handleChange}>
	     {Object.keys(options).map(function(key) {
	    	 return <option key={key} value={options[key]}>{key}</option>
	     })
	     }
	     </select>
	  } else if (elementType === 'textarea') {
		 input = <textarea type="text" className="form-control" value={this.props.value} onChange={this.handleChange} />
	  }
	  return(
      <div>
      <label className="col-sm-2 control-label">
        {this.props.label}
      </label>
      <div className="col-sm-4">
        {input}
      </div>
      </div>
    );
  }

}
