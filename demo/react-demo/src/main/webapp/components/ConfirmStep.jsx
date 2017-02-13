import React from 'react';
import AgentsTable from './AgentsTable';
import MetadataStep from './MetadataStep';

export default class ConfirmStep extends React.Component {

	constructor(props) {
		    super(props);

		  }


	  render() {
			const metadata = this.props.metadataStore.metadata;
			const developers = metadata.developers.slice();
			const devsLength = developers.length;
		    return (
		    <div>
		    <MetadataStep metadataStore={this.props.metadataStore}/>
				<AgentsTable developers={developers} finished={true} />
		    </div>
		      );
		  }
}
