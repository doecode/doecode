"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var React = require('react');

var SelectField = function (_React$Component) {
	_inherits(SelectField, _React$Component);

	function SelectField(props) {
		_classCallCheck(this, SelectField);

		var _this = _possibleConstructorReturn(this, (SelectField.__proto__ || Object.getPrototypeOf(SelectField)).call(this, props));

		_this.handleChange = _this.handleChange.bind(_this);

		return _this;
	}

	_createClass(SelectField, [{
		key: "handleChange",
		value: function handleChange(event) {
			this.props.onChange(this.props.field, event.target.value);
		}
	}, {
		key: "render",
		value: function render() {
			return React.createElement(
				"div",
				{ className: "form-group form-group-sm row" },
				React.createElement(
					"label",
					{ className: "col-xs-2 control-label" },
					this.props.label
				),
				React.createElement(
					"div",
					{ className: "col-xs-4" },
					React.createElement("select", { name: this.props.field, id: this.props.field, className: "form-control", value: this.props.value, onChange: this.handleChange })
				)
			);
		}
	}]);

	return SelectField;
}(React.Component);

module.exports = SelectField;