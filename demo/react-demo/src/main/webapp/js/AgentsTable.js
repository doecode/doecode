'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _class;

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _griddleReact = require('griddle-react');

var _griddleReact2 = _interopRequireDefault(_griddleReact);

var _mobxReact = require('mobx-react');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var AgentsTable = (0, _mobxReact.observer)(_class = function (_React$Component) {
  _inherits(AgentsTable, _React$Component);

  function AgentsTable(props) {
    _classCallCheck(this, AgentsTable);

    return _possibleConstructorReturn(this, (AgentsTable.__proto__ || Object.getPrototypeOf(AgentsTable)).call(this, props));
  }

  _createClass(AgentsTable, [{
    key: 'render',
    value: function render() {
      return _react2.default.createElement(
        'div',
        { className: 'form-group form-group-sm' },
        _react2.default.createElement(
          'div',
          { className: 'col-sm-offset-1 col-sm-10' },
          _react2.default.createElement(
            'h2',
            { className: 'no-margin-left' },
            'Developers'
          ),
          _react2.default.createElement(_griddleReact2.default, { results: this.props.value })
        ),
        _react2.default.createElement('div', { className: 'col-sm-1' })
      );
    }
  }]);

  return AgentsTable;
}(_react2.default.Component)) || _class;

exports.default = AgentsTable;