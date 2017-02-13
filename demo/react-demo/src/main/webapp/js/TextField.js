"use strict";

Object.defineProperty(exports, "__esModule", {
		value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require("react");

var _react2 = _interopRequireDefault(_react);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var TextField = function (_React$Component) {
		_inherits(TextField, _React$Component);

		function TextField(props) {
				_classCallCheck(this, TextField);

				var _this = _possibleConstructorReturn(this, (TextField.__proto__ || Object.getPrototypeOf(TextField)).call(this, props));

				_this.handleChange = _this.handleChange.bind(_this);

				return _this;
		}

		_createClass(TextField, [{
				key: "handleChange",
				value: function handleChange(event) {
						this.props.onChange(this.props.field, event.target.value);
				}
		}, {
				key: "render",
				value: function render() {
						var _this2 = this;

						var input = null;
						var elementType = this.props.elementType;

						var labelStyle = this.props.labelStyle != undefined ? this.props.labelStyle : "col-sm-2 control-label";
						var divStyle = this.props.labelStyle != undefined ? this.props.labelStyle : "col-sm-4";

						if (this.props.displayOnly) {
								input = this.props.value;
						} else if (elementType === 'input') {
								input = _react2.default.createElement("input", { type: "text", className: "form-control", value: this.props.value, onChange: this.handleChange });
						} else if (elementType === 'select') {
								(function () {
										var options = _this2.props.options;
										input = _react2.default.createElement(
												"select",
												{ className: "form-control", value: _this2.props.value, onChange: _this2.handleChange },
												Object.keys(options).map(function (key) {
														return _react2.default.createElement(
																"option",
																{ key: key, value: options[key] },
																key
														);
												}),
												"input += "
										);
								})();
						} else if (elementType === 'textarea') {
								input = _react2.default.createElement("textarea", { type: "text", className: "form-control", value: this.props.value, onChange: this.handleChange });
						}
						return _react2.default.createElement(
								"div",
								null,
								_react2.default.createElement(
										"label",
										{ className: "col-sm-2 control-label" },
										this.props.label
								),
								_react2.default.createElement(
										"div",
										{ className: "col-sm-4" },
										input
								)
						);
				}
		}]);

		return TextField;
}(_react2.default.Component);

exports.default = TextField;