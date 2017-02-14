'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactDom = require('react-dom');

var _reactDom2 = _interopRequireDefault(_reactDom);

var _reactBootstrap = require('react-bootstrap');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Splash = function (_React$Component) {
    _inherits(Splash, _React$Component);

    function Splash(props) {
        _classCallCheck(this, Splash);

        var _this = _possibleConstructorReturn(this, (Splash.__proto__ || Object.getPrototypeOf(Splash)).call(this, props));

        _this.state = { showModal: false };
        _this.deposit = _this.deposit.bind(_this);
        _this.open = _this.open.bind(_this);
        _this.close = _this.close.bind(_this);
        return _this;
    }

    _createClass(Splash, [{
        key: 'deposit',
        value: function deposit() {
            window.location.href = 'wizard.html';
        }
    }, {
        key: 'open',
        value: function open() {
            this.setState({ showModal: true });
        }
    }, {
        key: 'close',
        value: function close() {
            this.setState({ showModal: false });
        }
    }, {
        key: 'render',
        value: function render() {

            return _react2.default.createElement(
                'div',
                { className: 'container-fluid' },
                _react2.default.createElement(
                    'div',
                    { 'class': 'col-xs-12' },
                    _react2.default.createElement(
                        'p',
                        null,
                        'The Department of Energy (DOE) Office of Scientific and Technical Information (OSTI) is building a new DOE software center.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code is the reimagining of OSTI\'s current product for the submission of software, the Energy Science and Technology Software Center, or ',
                        _react2.default.createElement(
                            'a',
                            { href: '//www.osti.gov/moved/estsc/' },
                            'ESTSC'
                        ),
                        '.  Since DOE Code is still under development, if you need to submit, search, or order software, please visit the ESTSC site for instructions.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code, when launched, will provide a best-in-class service for the submission of software. As a form of scientific and technical information, software is a result of the Department\'s research and development activities at the DOE national laboratories and other DOE facilities/contractors.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code will provide ',
                        _react2.default.createElement(
                            'a',
                            { href: 'https://www.osti.gov/ostiblog/osti-developing-open-source-social-coding-platform-doe-scientific-software' },
                            'an open source, social platform for DOE scientific software'
                        ),
                        '.  DOE Code will connect to repositories on GitHub, Bitbucket, and others, but will also provide a place to host code for users that are unable to use other hosting services.  Since DOE Code is itself an open source product, other institutions will be able to download and deploy it for their own purposes too. You can follow DOE Code\u2019s development at the ',
                        _react2.default.createElement(
                            'a',
                            { href: 'https://github.com/doecode' },
                            'DOE Code GitHub site.'
                        )
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'To provide a new, modern way of interacting, DOE Code will not only provide the ability to link to references (papers, datasets) but also to other documents, manuals, examples, charts, forums, etc., in one place. All of this scientific and technical information will be linked to scientific software, whether it be software for modeling and simulation, data analytics or instrument control.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'The current software center, ESTSC, contains over 3,500 distinct pieces of software resulting from DOE R&D, as well as selected software from the Nuclear Energy Agency of the Organization for Economic Cooperation and Development.  ESTSC is the centralized DOE software management portal.  The ESTSC portal provides access to software packages, including source code, executable object code, and the minimum support documentation (e.g., software user guide or manual) needed to use the software or to modify the software to support subsequent development efforts.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'ESTSC and DOE Code are managed and operated by DOE OSTI.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'The Department of Energy (DOE) Office of Scientific and Technical Information (OSTI) is building a new DOE software center.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code is the reimagining of OSTI\'s current product for the submission of software, the Energy Science and Technology Software Center, or ',
                        _react2.default.createElement(
                            'a',
                            { href: '//www.osti.gov/moved/estsc/' },
                            'ESTSC'
                        ),
                        '.  Since DOE Code is still under development, if you need to submit, search, or order software, please visit the ESTSC site for instructions.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code, when launched, will provide a best-in-class service for the submission of software. As a form of scientific and technical information, software is a result of the Department\'s research and development activities at the DOE national laboratories and other DOE facilities/contractors.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'DOE Code will provide ',
                        _react2.default.createElement(
                            'a',
                            { href: 'https://www.osti.gov/ostiblog/osti-developing-open-source-social-coding-platform-doe-scientific-software' },
                            'an open source, social platform for DOE scientific software'
                        ),
                        '.  DOE Code will connect to repositories on GitHub, Bitbucket, and others, but will also provide a place to host code for users that are unable to use other hosting services.  Since DOE Code is itself an open source product, other institutions will be able to download and deploy it for their own purposes too. You can follow DOE Code\u2019s development at the ',
                        _react2.default.createElement(
                            'a',
                            { href: 'https://github.com/doecode' },
                            'DOE Code GitHub site.'
                        )
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'To provide a new, modern way of interacting, DOE Code will not only provide the ability to link to references (papers, datasets) but also to other documents, manuals, examples, charts, forums, etc., in one place. All of this scientific and technical information will be linked to scientific software, whether it be software for modeling and simulation, data analytics or instrument control.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'The current software center, ESTSC, contains over 3,500 distinct pieces of software resulting from DOE R&D, as well as selected software from the Nuclear Energy Agency of the Organization for Economic Cooperation and Development.  ESTSC is the centralized DOE software management portal.  The ESTSC portal provides access to software packages, including source code, executable object code, and the minimum support documentation (e.g., software user guide or manual) needed to use the software or to modify the software to support subsequent development efforts.'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'ESTSC and DOE Code are managed and operated by DOE OSTI.'
                    )
                ),
                _react2.default.createElement(
                    'div',
                    { className: 'row' },
                    _react2.default.createElement(
                        'div',
                        { className: 'col-sm-offset-3 col-sm-3' },
                        _react2.default.createElement(
                            'a',
                            { href: '#', className: 'thumbnail', onClick: this.deposit },
                            _react2.default.createElement(
                                'div',
                                { className: 'caption' },
                                _react2.default.createElement(
                                    'h2',
                                    null,
                                    'Add Your Project'
                                )
                            )
                        )
                    ),
                    _react2.default.createElement(
                        'div',
                        { className: 'col-sm-3' },
                        _react2.default.createElement(
                            'a',
                            { href: '#', className: 'thumbnail', onClick: this.open },
                            _react2.default.createElement(
                                'div',
                                { className: 'caption' },
                                _react2.default.createElement(
                                    'h2',
                                    null,
                                    'Create a Repository'
                                )
                            )
                        )
                    )
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
                            'Create a New Repository'
                        )
                    ),
                    _react2.default.createElement(
                        _reactBootstrap.Modal.Body,
                        null,
                        _react2.default.createElement(
                            'div',
                            { className: 'row' },
                            _react2.default.createElement(
                                'div',
                                { className: 'col-sm-5' },
                                'Create a new project as part of one of our open source communities below:',
                                _react2.default.createElement(
                                    'ul',
                                    null,
                                    _react2.default.createElement(
                                        'li',
                                        null,
                                        _react2.default.createElement(
                                            'a',
                                            { href: 'https://github.com/doecode/' },
                                            'GitHub'
                                        ),
                                        ' '
                                    )
                                )
                            ),
                            _react2.default.createElement(
                                'div',
                                { className: 'col-sm-2' },
                                _react2.default.createElement(
                                    'h1',
                                    null,
                                    ' OR '
                                )
                            ),
                            _react2.default.createElement(
                                'div',
                                { className: 'col-sm-5' },
                                'Create a new project on our internal ',
                                _react2.default.createElement(
                                    'a',
                                    { href: 'http://lxdevrepo.osti.gov/' },
                                    'DOE Code repository'
                                ),
                                ' where you can control access to the project.'
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
                        )
                    )
                )
            );
        }
    }]);

    return Splash;
}(_react2.default.Component);

_reactDom2.default.render(_react2.default.createElement(Splash, null), document.getElementById('root'));
