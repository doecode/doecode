'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var React = require('react');
var ReactDOM = require('react-dom');
var Griddle = require('griddle-react');
var ReactBootstrap = require('react-bootstrap');
var utils = require('./utils.js');
var TextField = require('./TextField');
var SelectField = require('./SelectField');
var AgentsModal = require('./AgentsModal');
var AgentsTable = require('./AgentsTable');

var NameForm = function (_React$Component) {
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

    return _this;
  }

  _createClass(NameForm, [{
    key: 'componentWillMount',
    value: function componentWillMount() {
      utils.doAjax('GET', 'services?action=load', this.parseLoadResponse);
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
      utils.doAjax('POST', 'services?action=save', this.parseSaveResponse, this.state.metadata);

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

      return React.createElement(
        'div',
        { className: 'container-fluid' },
        React.createElement(
          'form',
          { id: 'react_form', className: 'form-horizontal', onSubmit: this.handleSubmit },
          React.createElement(TextField, { field: 'software_title', label: 'Software Title', type: 'textarea', value: this.state.metadata.software_title, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'acronym', label: 'Acronym or Short Title', type: 'text', value: this.state.metadata.acronym, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'description', label: 'Software Title', type: 'textarea', value: this.state.metadata.description, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'disclaimers', label: 'Disclaimers', type: 'text', value: this.state.metadata.disclaimers, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'doi', label: 'DOI', type: 'text', value: this.state.metadata.doi, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'keywords', label: 'Keywords', type: 'text', value: this.state.metadata.keywords, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'license', label: 'License', type: 'select', value: this.state.metadata.license, onChange: this.onStateChange }),
          React.createElement(SelectField, { field: 'open_source', label: 'Open Source?', type: 'select', value: this.state.metadata.open_source, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'originating_research_organizations', label: 'Originating Research Organizations', type: 'text', value: this.state.metadata.originating_research_organizations, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'other_special_requirements', label: 'Other Special Requirements', type: 'text', value: this.state.metadata.other_special_requirements, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'recipient_email', label: 'Recipient Email', type: 'text', value: this.state.metadata.recipient_email, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'recipient_name', label: 'Recipient Name', type: 'text', value: this.state.metadata.recipient_name, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'recipient_org', label: 'Recipient Organization', type: 'text', value: this.state.metadata.recipient_org, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'recipient_phone', label: 'Recipient Phone Number', type: 'text', value: this.state.metadata.recipient_phone, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'related_identifiers', label: 'Related Identifiers', type: 'text', value: this.state.metadata.related_identifiers, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'related_software', label: 'Related Software', type: 'text', value: this.state.metadata.related_software, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'repository_link', label: 'Repository Link', type: 'text', value: this.state.metadata.repository_link, onChange: this.onStateChange }),
          React.createElement(TextField, { field: 'site_accession_number', label: 'Site Accession Number', type: 'text', value: this.state.metadata.site_accession_number, onChange: this.onStateChange }),
          React.createElement(SelectField, { field: 'site_ownership_code', label: 'Site Ownership Code', type: 'select', value: this.state.metadata.site_ownership_code, onChange: this.onStateChange }),
          React.createElement(AgentsTable, { value: this.state.metadata.developers }),
          React.createElement(AgentsModal, { onClick: this.onModalSubmit }),
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
        )
      );
    }
  }]);

  return NameForm;
}(React.Component);

ReactDOM.render(React.createElement(NameForm, null), document.getElementById('root'));