'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var React = require('react');
var ReactBootstrap = require('react-bootstrap');
var TextField = require('./TextField');
var SelectField = require('./SelectField');

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
      return React.createElement(
        'div',
        { className: 'form-group form-group-sm' },
        React.createElement(
          'div',
          { className: 'col-xs-offset-5' },
          React.createElement(
            ReactBootstrap.Button,
            {
              bsStyle: 'primary',
              bsSize: 'large',
              onClick: this.open
            },
            'Add Developer'
          ),
          React.createElement(
            ReactBootstrap.Modal,
            { show: this.state.showModal, onHide: this.close, bsSize: 'large' },
            React.createElement(
              ReactBootstrap.Modal.Header,
              { closeButton: true },
              React.createElement(
                ReactBootstrap.Modal.Title,
                null,
                'Manage Developer'
              )
            ),
            React.createElement(
              ReactBootstrap.Modal.Body,
              null,
              React.createElement(
                'div',
                { className: 'container-fluid' },
                React.createElement(
                  'div',
                  { className: 'form-horizontal' },
                  React.createElement(TextField, { field: 'first_name', label: 'First Name', type: 'textarea', value: this.state.developer.first_name, onChange: this.onModalChange }),
                  React.createElement(TextField, { field: 'middle_name', label: 'Middle Name', type: 'textarea', value: this.state.developer.middle_name, onChange: this.onModalChange }),
                  React.createElement(TextField, { field: 'last_name', label: 'Last Name', type: 'textarea', value: this.state.developer.last_name, onChange: this.onModalChange }),
                  React.createElement(TextField, { field: 'email', label: 'Email', type: 'textarea', value: this.state.developer.email, onChange: this.onModalChange })
                )
              )
            ),
            React.createElement(
              ReactBootstrap.Modal.Footer,
              null,
              React.createElement(
                ReactBootstrap.Button,
                { onClick: this.close },
                'Close'
              ),
              React.createElement(
                ReactBootstrap.Button,
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
}(React.Component);

module.exports = AgentsModal;