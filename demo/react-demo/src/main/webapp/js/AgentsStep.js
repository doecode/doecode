'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var React = require('react');
var AgentsModal = require('./AgentsModal');
var AgentsTable = require('./AgentsTable');

var AgentsStep = function (_React$Component) {
	_inherits(AgentsStep, _React$Component);

	function AgentsStep(props) {
		_classCallCheck(this, AgentsStep);

		return _possibleConstructorReturn(this, (AgentsStep.__proto__ || Object.getPrototypeOf(AgentsStep)).call(this, props));
	}

	_createClass(AgentsStep, [{
		key: 'render',
		value: function render() {

			return React.createElement(
				'div',
				null,
				React.createElement(AgentsTable, { value: this.props.developers }),
				React.createElement(AgentsModal, { onClick: this.props.onModalSubmit }),
				React.createElement(
					'div',
					{ className: 'form-group form-group-sm' },
					React.createElement(
						'div',
						{ className: 'col-xs-offset-2' },
						React.createElement(
							'button',
							{ className: 'btn btn-primary', type: 'submit' },
							'Submit'
						)
					)
				)
			);
		}
	}]);

	return AgentsStep;
}(React.Component);

module.exports = AgentsStep;