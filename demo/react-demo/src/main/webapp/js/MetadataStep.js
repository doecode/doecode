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

    var _this = _possibleConstructorReturn(this, (MetadataStep.__proto__ || Object.getPrototypeOf(MetadataStep)).call(this, props));

    _this.onFieldChange = _this.onFieldChange.bind(_this);
    _this.isValidated = _this._isValidated.bind(_this);
    return _this;
  }

  _createClass(MetadataStep, [{
    key: '_isValidated',
    value: function _isValidated() {
      //adding validations later

      return true;
    }
  }, {
    key: 'onFieldChange',
    value: function onFieldChange(id, value) {
      this.props.metadataStore.metadata[id] = value;
    }
  }, {
    key: 'render',
    value: function render() {
      var metadata = this.props.metadataStore.metadata;
      return _react2.default.createElement(
        'div',
        { className: 'container-fluid' },
        _react2.default.createElement(
          'form',
          { id: 'react_form', className: 'form-horizontal col-sm-offset-2 col-sm-8' },
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'repository_link', label: 'Repository Link', elementType: 'input', value: metadata.repository_link, onChange: this.onFieldChange }),
            _react2.default.createElement(
              'button',
              { className: 'btn btn-primary btn-sm', onClick: this.props.autopopulate },
              ' Autopopulate '
            ),
            _react2.default.createElement('div', { className: 'col-sm-6' })
          ),
          _react2.default.createElement('hr', null),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'software_title', label: 'Software Title', elementType: 'input', value: metadata.software_title, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'acronym', label: 'Acronym or Short Title', elementType: 'input', value: metadata.acronym, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'description', label: 'Software Title', elementType: 'input', value: metadata.description, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'disclaimers', label: 'Disclaimers', elementType: 'input', value: metadata.disclaimers, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'doi', label: 'DOI', elementType: 'input', value: metadata.doi, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'keywords', label: 'Keywords', elementType: 'input', value: metadata.keywords, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'license', label: 'License', elementType: 'select', value: metadata.license, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'originating_research_organizations', label: 'Originating Research Organizations', elementType: 'input', value: metadata.originating_research_organizations, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'other_special_requirements', label: 'Other Special Requirements', elementType: 'input', value: metadata.other_special_requirements, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'recipient_email', label: 'Recipient Email', elementType: 'input', value: metadata.recipient_email, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'recipient_name', label: 'Recipient Name', elementType: 'input', value: metadata.recipient_name, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'recipient_org', label: 'Recipient Organization', elementType: 'input', value: metadata.recipient_org, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'recipient_phone', label: 'Recipient Phone Number', elementType: 'input', value: metadata.recipient_phone, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'related_identifiers', label: 'Related Identifiers', elementType: 'input', value: metadata.related_identifiers, onChange: this.onFieldChange })
          ),
          _react2.default.createElement(
            'div',
            { className: 'form-group form-group-sm row' },
            _react2.default.createElement(_TextField2.default, { field: 'related_software', label: 'Related Software', elementType: 'input', value: metadata.related_software, onChange: this.onFieldChange }),
            _react2.default.createElement(_TextField2.default, { field: 'site_accession_number', label: 'Site Accession Number', elementType: 'input', value: metadata.site_accession_number, onChange: this.onFieldChange })
          )
        )
      );
    }
  }]);

  return MetadataStep;
}(_react2.default.Component)) || _class;

exports.default = MetadataStep;