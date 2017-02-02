import React from 'react'

export default class PlaceLink extends React.Component {

	constructor(props) {
		super(props);
	}
	
	render() {
		
		return	(
				<a href="#">{this.props.data}</a>
		);
	}
}