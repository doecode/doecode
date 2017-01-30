'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _desc, _value, _class, _descriptor, _descriptor2, _class3;

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactDom = require('react-dom');

var _reactDom2 = _interopRequireDefault(_reactDom);

var _utils = require('./utils');

var _TextField = require('./TextField');

var _TextField2 = _interopRequireDefault(_TextField);

var _SelectField = require('./SelectField');

var _SelectField2 = _interopRequireDefault(_SelectField);

var _AgentsStep = require('./AgentsStep');

var _AgentsStep2 = _interopRequireDefault(_AgentsStep);

var _mobxReact = require('mobx-react');

var _mobx = require('mobx');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

function _initDefineProp(target, property, descriptor, context) {
  if (!descriptor) return;
  Object.defineProperty(target, property, {
    enumerable: descriptor.enumerable,
    configurable: descriptor.configurable,
    writable: descriptor.writable,
    value: descriptor.initializer ? descriptor.initializer.call(context) : void 0
  });
}

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _applyDecoratedDescriptor(target, property, decorators, descriptor, context) {
  var desc = {};
  Object['ke' + 'ys'](descriptor).forEach(function (key) {
    desc[key] = descriptor[key];
  });
  desc.enumerable = !!desc.enumerable;
  desc.configurable = !!desc.configurable;

  if ('value' in desc || desc.initializer) {
    desc.writable = true;
  }

  desc = decorators.slice().reverse().reduce(function (desc, decorator) {
    return decorator(target, property, desc) || desc;
  }, desc);

  if (context && desc.initializer !== void 0) {
    desc.value = desc.initializer ? desc.initializer.call(context) : void 0;
    desc.initializer = undefined;
  }

  if (desc.initializer === void 0) {
    Object['define' + 'Property'](target, property, desc);
    desc = null;
  }

  return desc;
}

function _initializerWarningHelper(descriptor, context) {
  throw new Error('Decorating class property failed. Please ensure that transform-class-properties is enabled.');
}

var Metadata = (_class = function Metadata() {
  _classCallCheck(this, Metadata);

  _initDefineProp(this, 'software_title', _descriptor, this);

  _initDefineProp(this, 'acronym', _descriptor2, this);
}, (_descriptor = _applyDecoratedDescriptor(_class.prototype, 'software_title', [_mobx.observable], {
  enumerable: true,
  initializer: function initializer() {
    return "";
  }
}), _descriptor2 = _applyDecoratedDescriptor(_class.prototype, 'acronym', [_mobx.observable], {
  enumerable: true,
  initializer: function initializer() {
    return "";
  }
})), _class);


var store = new Metadata();

var NameForm = (0, _mobxReact.observer)(_class3 = function (_React$Component) {
  _inherits(NameForm, _React$Component);

  function NameForm(props) {
    _classCallCheck(this, NameForm);

    var _this = _possibleConstructorReturn(this, (NameForm.__proto__ || Object.getPrototypeOf(NameForm)).call(this, props));

    _this.state = { metadata: {
        "code_id": undefined,
        "site_ownership_code": undefined,
        "open_source": undefined,
        "repository_link": undefined,
        "developers": [],
        "originating_research_organizations": undefined,
        "software_title": undefined,
        "acronym": undefined,
        "doi": undefined,
        "description": undefined,
        "related_identifiers": undefined,
        "country_of_origin": undefined,
        "keywords": undefined,
        "disclaimers": undefined,
        "license": undefined,
        "recipient_name": undefined,
        "recipient_email": undefined,
        "recipient_phone": undefined,
        "recipient_org": undefined,
        "site_accession_number": undefined,
        "other_special_requirements": undefined,
        "related_software": undefined
      }
    };
    _this.handleSubmit = _this.handleSubmit.bind(_this);
    _this.parseLoadResponse = _this.parseLoadResponse.bind(_this);
    _this.parseSaveResponse = _this.parseSaveResponse.bind(_this);
    _this.onStateChange = _this.onStateChange.bind(_this);
    _this.onModalSubmit = _this.onModalSubmit.bind(_this);

    console.log(_this.props);

    return _this;
  }

  _createClass(NameForm, [{
    key: 'componentWillMount',
    value: function componentWillMount() {
      (0, _utils.doAjax)('GET', 'services?action=load', this.parseLoadResponse);
    }
  }, {
    key: 'parseLoadResponse',
    value: function parseLoadResponse(responseData) {
      this.setState({
        metadata: responseData.metadata
      });
    }
  }, {
    key: 'onStateChange',
    value: function onStateChange(id, value) {
      var newState = this.state;
      newState.metadata[id] = value;
      this.setState(newState);
    }
  }, {
    key: 'onModalSubmit',
    value: function onModalSubmit(developer) {
      var newState = this.state;
      newState.metadata.developers.push(developer);
      this.setState(newState);
    }
  }, {
    key: 'handleSubmit',
    value: function handleSubmit(event) {
      console.log(this.state.metadata);
      console.log(this.store);
      (0, _utils.doAjax)('POST', 'services?action=save', this.parseSaveResponse, this.state.metadata);

      event.preventDefault();
    }
  }, {
    key: 'parseSaveResponse',
    value: function parseSaveResponse(data) {
      alert('Saved record');
    }
  }, {
    key: 'render',
    value: function render() {

      return _react2.default.createElement(
        'div',
        { className: 'container-fluid' },
        _react2.default.createElement(
          'form',
          { id: 'react_form', className: 'form-horizontal', onSubmit: this.handleSubmit },
          _react2.default.createElement(_TextField2.default, { field: 'software_title', label: 'Software Title', type: 'textarea', value: this.state.metadata.software_title }),
          _react2.default.createElement(_TextField2.default, { field: 'acronym', label: 'Acronym or Short Title', type: 'text', value: this.state.metadata.acronym }),
          _react2.default.createElement(_TextField2.default, { field: 'description', label: 'Software Title', type: 'textarea', value: this.state.metadata.description, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'disclaimers', label: 'Disclaimers', type: 'text', value: this.state.metadata.disclaimers, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'doi', label: 'DOI', type: 'text', value: this.state.metadata.doi, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'keywords', label: 'Keywords', type: 'text', value: this.state.metadata.keywords, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'license', label: 'License', type: 'select', value: this.state.metadata.license, onChange: this.onStateChange }),
          _react2.default.createElement(_SelectField2.default, { field: 'open_source', label: 'Open Source?', type: 'select', value: this.state.metadata.open_source, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'originating_research_organizations', label: 'Originating Research Organizations', type: 'text', value: this.state.metadata.originating_research_organizations, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'other_special_requirements', label: 'Other Special Requirements', type: 'text', value: this.state.metadata.other_special_requirements, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'recipient_email', label: 'Recipient Email', type: 'text', value: this.state.metadata.recipient_email, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'recipient_name', label: 'Recipient Name', type: 'text', value: this.state.metadata.recipient_name, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'recipient_org', label: 'Recipient Organization', type: 'text', value: this.state.metadata.recipient_org, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'recipient_phone', label: 'Recipient Phone Number', type: 'text', value: this.state.metadata.recipient_phone, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'related_identifiers', label: 'Related Identifiers', type: 'text', value: this.state.metadata.related_identifiers, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'related_software', label: 'Related Software', type: 'text', value: this.state.metadata.related_software, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'repository_link', label: 'Repository Link', type: 'text', value: this.state.metadata.repository_link, onChange: this.onStateChange }),
          _react2.default.createElement(_TextField2.default, { field: 'site_accession_number', label: 'Site Accession Number', type: 'text', value: this.state.metadata.site_accession_number, onChange: this.onStateChange }),
          _react2.default.createElement(_SelectField2.default, { field: 'site_ownership_code', label: 'Site Ownership Code', type: 'select', value: this.state.metadata.site_ownership_code, onChange: this.onStateChange }),
          _react2.default.createElement(_AgentsStep2.default, { developers: this.state.metadata.developers, onModalSubmit: this.onModalSubmit })
        )
      );
    }
  }]);

  return NameForm;
}(_react2.default.Component)) || _class3;

_reactDom2.default.render(_react2.default.createElement(NameForm, { store: store }), document.getElementById('root'));