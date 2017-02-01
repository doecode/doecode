'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _class;

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

var _Metadata = require('./Metadata');

var _Metadata2 = _interopRequireDefault(_Metadata);

var _MetadataStep = require('./MetadataStep');

var _MetadataStep2 = _interopRequireDefault(_MetadataStep);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var store = new _Metadata2.default();

var NameForm = (0, _mobxReact.observer)(_class = function (_React$Component) {
    _inherits(NameForm, _React$Component);

    function NameForm(props) {
        _classCallCheck(this, NameForm);

        var _this = _possibleConstructorReturn(this, (NameForm.__proto__ || Object.getPrototypeOf(NameForm)).call(this, props));

        _this.handleSubmit = _this.handleSubmit.bind(_this);
        _this.parseLoadResponse = _this.parseLoadResponse.bind(_this);
        _this.parseSaveResponse = _this.parseSaveResponse.bind(_this);
        _this.onMobxChange = _this.onMobxChange.bind(_this);
        _this.onModalSubmit = _this.onModalSubmit.bind(_this);
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
            this.props.store.metadata = responseData.metadata;
        }
    }, {
        key: 'onMobxChange',
        value: function onMobxChange(id, value) {
            this.props.store.metadata[id] = value;
        }
    }, {
        key: 'onModalSubmit',
        value: function onModalSubmit(developer) {
            this.props.store.addToDevelopers(developer);
        }
    }, {
        key: 'handleSubmit',
        value: function handleSubmit(event) {
            (0, _utils.doAjax)('POST', 'services?action=save', this.parseSaveResponse, this.props.store.metadata);
            event.preventDefault();
        }
    }, {
        key: 'parseSaveResponse',
        value: function parseSaveResponse(data) {
            alert('Saved record');
            console.log(data);
        }
    }, {
        key: 'render',
        value: function render() {
            var metadata = store.metadata;
            return _react2.default.createElement(
                'div',
                { className: 'container-fluid' },
                _react2.default.createElement(
                    'form',
                    { id: 'react_form', className: 'form-horizontal', onSubmit: this.handleSubmit },
                    _react2.default.createElement(_MetadataStep2.default, { metadata: metadata, onMobxChange: this.onMobxChange }),
                    _react2.default.createElement(_AgentsStep2.default, { developers: metadata.developers.slice(), onModalSubmit: this.onModalSubmit }),
                    _react2.default.createElement(
                        'div',
                        { className: 'form-group form-group-sm' },
                        _react2.default.createElement(
                            'div',
                            { className: 'col-xs-offset-2' },
                            _react2.default.createElement(
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
}(_react2.default.Component)) || _class;

_reactDom2.default.render(_react2.default.createElement(NameForm, { store: store }), document.getElementById('root'));