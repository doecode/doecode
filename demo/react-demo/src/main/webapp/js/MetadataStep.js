'use strict';

Object.defineProperty(exports, "__esModule", {
	value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _class;

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _TextField = require('./TextField');

var _TextField2 = _interopRequireDefault(_TextField);

var _mobxReact = require('mobx-react');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var MetadataStep = (0, _mobxReact.observer)(_class = function (_React$Component) {
	_inherits(MetadataStep, _React$Component);

	function MetadataStep(props) {
		_classCallCheck(this, MetadataStep);

		return _possibleConstructorReturn(this, (MetadataStep.__proto__ || Object.getPrototypeOf(MetadataStep)).call(this, props));
	}

	_createClass(MetadataStep, [{
		key: 'render',
		value: function render() {
			var metadata = this.props.metadata;
			return _react2.default.createElement(
				'div',
				null,
				_react2.default.createElement(_TextField2.default, { field: 'software_title', label: 'Software Title', type: 'textarea', value: metadata.software_title, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'acronym', label: 'Acronym or Short Title', type: 'text', value: metadata.acronym, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'description', label: 'Software Title', type: 'textarea', value: metadata.description, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'disclaimers', label: 'Disclaimers', type: 'text', value: metadata.disclaimers, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'doi', label: 'DOI', type: 'text', value: metadata.doi, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'keywords', label: 'Keywords', type: 'text', value: metadata.keywords, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'license', label: 'License', type: 'select', value: metadata.license, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'originating_research_organizations', label: 'Originating Research Organizations', type: 'text', value: metadata.originating_research_organizations, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'other_special_requirements', label: 'Other Special Requirements', type: 'text', value: metadata.other_special_requirements, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'recipient_email', label: 'Recipient Email', type: 'text', value: metadata.recipient_email, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'recipient_name', label: 'Recipient Name', type: 'text', value: metadata.recipient_name, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'recipient_org', label: 'Recipient Organization', type: 'text', value: metadata.recipient_org, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'recipient_phone', label: 'Recipient Phone Number', type: 'text', value: metadata.recipient_phone, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'related_identifiers', label: 'Related Identifiers', type: 'text', value: metadata.related_identifiers, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'related_software', label: 'Related Software', type: 'text', value: metadata.related_software, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'repository_link', label: 'Repository Link', type: 'text', value: metadata.repository_link, onChange: this.props.onMobxChange }),
				_react2.default.createElement(_TextField2.default, { field: 'site_accession_number', label: 'Site Accession Number', type: 'text', value: metadata.site_accession_number, onChange: this.props.onMobxChange })
			);
		}
	}]);

	return MetadataStep;
}(_react2.default.Component)) || _class;

exports.default = MetadataStep;