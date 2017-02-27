import DOECodeWizard from './components/DOECodeWizard';
import Splash from './splash/Splash';
import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, browserHistory,IndexRoute} from 'react-router';

class DOECodeRouter extends React.Component {
	
	constructor(props) {
		super(props);
	}
	
	render() {
		return (
		<Router history={browserHistory}>
			<Route path="/" component={Splash}/>
			<Route path="/wizard" component={DOECodeWizard}/>
		</Router>
		);
	}
}

ReactDOM.render(
    <DOECodeRouter/>, document.getElementById('root'));