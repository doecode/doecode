'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _class;

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactBootstrap = require('react-bootstrap');

var _TextField = require('./TextField');

var _TextField2 = _interopRequireDefault(_TextField);

var _SelectField = require('./SelectField');

var _SelectField2 = _interopRequireDefault(_SelectField);

var _mobxReact = require('mobx-react');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var AgentsModal = (0, _mobxReact.observer)(_class = function (_React$Component) {
    _inherits(AgentsModal, _React$Component);

    function AgentsModal(props) {
        _classCallCheck(this, AgentsModal);

        var _this = _possibleConstructorReturn(this, (AgentsModal.__proto__ || Object.getPrototypeOf(AgentsModal)).call(this, props));

        _this.open = _this.open.bind(_this);
        _this.close = _this.close.bind(_this);
        _this.onModalChange = _this.onModalChange.bind(_this);
        _this.handleSave = _this.handleSave.bind(_this);
        _this.handleDelete = _this.handleDelete.bind(_this);
        return _this;
    }

    _createClass(AgentsModal, [{
        key: 'close',
        value: function close() {
            this.props.developerStore.showModal = false;
            this.props.developerStore.clear();
        }
    }, {
        key: 'open',
        value: function open() {
            this.props.developerStore.isEdit = false;
            this.props.developerStore.showModal = true;
            this.props.developerStore.clear();
        }
    }, {
        key: 'onModalChange',
        value: function onModalChange(id, value) {
            this.props.developerStore.developer[id] = value;
        }
    }, {
        key: 'handleSave',
        value: function handleSave(event) {

            var dev = Object.assign({}, this.props.developerStore.developer);

            if (this.props.developerStore.isEdit) {
                this.props.metadataStore.modifyDeveloper(dev, this.props.developerStore.previousPlace);
            } else {
                this.props.metadataStore.addToDevelopers(dev);
            }
            this.close();
        }
    }, {
        key: 'handleDelete',
        value: function handleDelete(event) {
            var dev = Object.assign({}, this.props.developerStore.developer);
            this.props.metadataStore.removeDeveloper(dev);
            this.close();
        }
    }, {
        key: 'render',
        value: function render() {
            var developer = this.props.developerStore.developer;
            var showModal = this.props.developerStore.showModal;
            var isEdit = this.props.developerStore.isEdit;

            return _react2.default.createElement(
                'div',
                { className: 'form-group form-group-sm' },
                _react2.default.createElement(
                    'div',
                    { className: 'col-xs-offset-5' },
                    _react2.default.createElement(
                        _reactBootstrap.Button,
                        { bsStyle: 'primary', bsSize: 'large', onClick: this.open },
                        'Add Developer'
                    ),
                    _react2.default.createElement(
                        _reactBootstrap.Modal,
                        { show: showModal, onHide: this.close, bsSize: 'large' },
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
                                    isEdit && _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'place', label: 'Place', type: 'number', value: developer.place, onChange: this.onModalChange })
                                    ),
                                    _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'first_name', label: 'First Name', type: 'text', value: developer.first_name, onChange: this.onModalChange })
                                    ),
                                    _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'middle_name', label: 'Middle Name', type: 'text', value: developer.middle_name, onChange: this.onModalChange })
                                    ),
                                    _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'last_name', label: 'Last Name', type: 'text', value: developer.last_name, onChange: this.onModalChange })
                                    ),
                                    _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'email', label: 'Email', type: 'text', value: developer.email, onChange: this.onModalChange })
                                    ),
                                    _react2.default.createElement(
                                        'div',
                                        { className: 'form-group form-group-sm row' },
                                        _react2.default.createElement(_TextField2.default, { field: 'affiliations', label: 'Affiliations', type: 'text', value: developer.affiliations, onChange: this.onModalChange })
                                    )
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
                            isEdit && _react2.default.createElement(
                                _reactBootstrap.Button,
                                { bsStyle: 'danger', onClick: this.handleDelete },
                                'Delete'
                            ),
                            _react2.default.createElement(
                                _reactBootstrap.Button,
                                { bsStyle: 'primary', onClick: this.handleSave },
                                'Save and close'
                            )
                        )
                    )
                )
            );
        }
    }]);

    return AgentsModal;
}(_react2.default.Component)) || _class;

exports.default = AgentsModal;