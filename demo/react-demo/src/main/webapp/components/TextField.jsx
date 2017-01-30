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
	  return(
      <div className="form-group form-group-sm row">
      <label className="col-xs-2 control-label">
        {this.props.label}
      </label>
      <div className="col-xs-4">
        <input type="text" name={this.props.field} id={this.props.field} className="form-control" value={this.props.value} onChange={this.handleChange} />
      </div>
    </div>);
  }

}

