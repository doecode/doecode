'use strict';

Object.defineProperty(exports, "__esModule", {
	value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _class;

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _AgentsModal = require('./AgentsModal');

var _AgentsModal2 = _interopRequireDefault(_AgentsModal);

var _AgentsTable = require('./AgentsTable');

var _AgentsTable2 = _interopRequireDefault(_AgentsTable);

var _Developer = require('./Developer');

var _Developer2 = _interopRequireDefault(_Developer);

var _mobxReact = require('mobx-react');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var developerStore = new _Developer2.default();

var AgentsStep = (0, _mobxReact.observer)(_class = function (_React$Component) {
	_inherits(AgentsStep, _React$Component);

	function AgentsStep(props) {
		_classCallCheck(this, AgentsStep);

		var _this = _possibleConstructorReturn(this, (AgentsStep.__proto__ || Object.getPrototypeOf(AgentsStep)).call(this, props));

		_this.isValidated = _this._isValidated.bind(_this);
		return _this;
	}

	_createClass(AgentsStep, [{
		key: '_isValidated',
		value: function _isValidated() {
			this.props.handleSubmit();
			return true;
		}
	}, {
		key: 'render',
		value: function render() {
			var metadata = this.props.metadataStore.metadata;
			return _react2.default.createElement(
				'div',
				null,
				_react2.default.createElement(_AgentsTable2.default, { developers: metadata.developers.slice(), developerStore: developerStore }),
				_react2.default.createElement(_AgentsModal2.default, { developerStore: developerStore, metadataStore: this.props.metadataStore })
			);
		}
	}]);

	return AgentsStep;
}(_react2.default.Component)) || _class;

exports.default = AgentsStep;