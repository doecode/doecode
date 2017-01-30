'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactBootstrap = require('react-bootstrap');

var _TextField = require('./TextField');

var _TextField2 = _interopRequireDefault(_TextField);

var _SelectField = require('./SelectField');

var _SelectField2 = _interopRequireDefault(_SelectField);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var AgentsModal = function (_React$Component) {
  _inherits(AgentsModal, _React$Component);

  function AgentsModal(props) {
    _classCallCheck(this, AgentsModal);

    var _this = _possibleConstructorReturn(this, (AgentsModal.__proto__ || Object.getPrototypeOf(AgentsModal)).call(this, props));

    var developerObj = { first_name: '',
      middle_name: '',
      last_name: '',
      email: '' };
    _this.state = { showModal: false, developer: developerObj };
    _this.open = _this.open.bind(_this);
    _this.close = _this.close.bind(_this);
    _this.onModalChange = _this.onModalChange.bind(_this);
    _this.handleSave = _this.handleSave.bind(_this);
    return _this;
  }

  _createClass(AgentsModal, [{
    key: 'close',
    value: function close() {
      var newState = this.state;
      var developerObj = { first_name: '',
        middle_name: '',
        last_name: '',
        email: '' };
      newState.showModal = false;
      newState.developer = developerObj;
      this.setState(newState);
    }
  }, {
    key: 'open',
    value: function open() {
      var newState = this.state;
      newState.showModal = true;
      this.setState(newState);
    }
  }, {
    key: 'onModalChange',
    value: function onModalChange(id, value) {
      var newState = this.state;
      newState.developer[id] = value;
      this.setState(newState);
    }
  }, {
    key: 'handleSave',
    value: function handleSave(event) {
      this.props.onClick(this.state.developer);
      this.close();
    }
  }, {
    key: 'render',
    value: function render() {
      return _react2.default.createElement(
        'div',
        { className: 'form-group form-group-sm' },
        _react2.default.createElement(
          'div',
          { className: 'col-xs-offset-5' },
          _react2.default.createElement(
            _reactBootstrap.Button,
            {
              bsStyle: 'primary',
              bsSize: 'large',
              onClick: this.open
            },
            'Add Developer'
          ),
          _react2.default.createElement(
            _reactBootstrap.Modal,
            { show: this.state.showModal, onHide: this.close, bsSize: 'large' },
            _react2.default.createElement(
              _reactBootstrap.Modal.Header,
              { closeButton: true },
              _react2.default.createElement(
                _reactBootstrap.Modal.Title,
                null,
                'Manage Developer'
              )
            ),
            _react2.default.createElement(
              _reactBootstrap.Modal.Body,
              null,
              _react2.default.createElement(
                'div',
                { className: 'container-fluid' },
                _react2.default.createElement(
                  'div',
                  { className: 'form-horizontal' },
                  _react2.default.createElement(_TextField2.default, { field: 'first_name', label: 'First Name', type: 'textarea', value: this.state.developer.first_name, onChange: this.onModalChange }),
                  _react2.default.createElement(_TextField2.default, { field: 'middle_name', label: 'Middle Name', type: 'textarea', value: this.state.developer.middle_name, onChange: this.onModalChange }),
                  _react2.default.createElement(_TextField2.default, { field: 'last_name', label: 'Last Name', type: 'textarea', value: this.state.developer.last_name, onChange: this.onModalChange }),
                  _react2.default.createElement(_TextField2.default, { field: 'email', label: 'Email', type: 'textarea', value: this.state.developer.email, onChange: this.onModalChange })
                )
              )
            ),
            _react2.default.createElement(
              _reactBootstrap.Modal.Footer,
              null,
              _react2.default.createElement(
                _reactBootstrap.Button,
                { onClick: this.close },
                'Close'
              ),
              _react2.default.createElement(
                _reactBootstrap.Button,
                { onClick: this.handleSave },
                'Save and close'
              )
            )
          )
        )
      );
    }
  }]);

  return AgentsModal;
}(_react2.default.Component);

exports.default = AgentsModal;