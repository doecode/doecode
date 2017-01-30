const React = require('react');
const Griddle = require('griddle-react');

class AgentsTable extends React.Component {
  constructor(props) {
    super(props);
  }


  render() {
    return(

<div className="form-group form-group-sm">
      <div className="col-sm-offset-2 col-sm-8">
        <h2>Developers</h2>
        <Griddle results = {this.props.value} />
      </div>
</div>
);
  }

}

module.exports = AgentsTable;
