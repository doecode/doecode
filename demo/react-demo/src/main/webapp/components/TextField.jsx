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
	  
	  
	  if (elementType === 'input') {
		input = <input type="text" className="form-control" value={this.props.value} onChange={this.handleChange} />
	  } else if (elementType === 'select') {
	     input = <select className="form-control" value={this.props.value} onChange={this.handleChange} />
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

