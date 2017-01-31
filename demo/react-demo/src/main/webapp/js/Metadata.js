'use strict';

Object.defineProperty(exports, "__esModule", {
   value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _dec, _desc, _value, _class, _descriptor, _descriptor2;

var _mobx = require('mobx');

function _initDefineProp(target, property, descriptor, context) {
   if (!descriptor) return;
   Object.defineProperty(target, property, {
      enumerable: descriptor.enumerable,
      configurable: descriptor.configurable,
      writable: descriptor.writable,
      value: descriptor.initializer ? descriptor.initializer.call(context) : void 0
   });
}

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _applyDecoratedDescriptor(target, property, decorators, descriptor, context) {
   var desc = {};
   Object['ke' + 'ys'](descriptor).forEach(function (key) {
      desc[key] = descriptor[key];
   });
   desc.enumerable = !!desc.enumerable;
   desc.configurable = !!desc.configurable;

   if ('value' in desc || desc.initializer) {
      desc.writable = true;
   }

   desc = decorators.slice().reverse().reduce(function (desc, decorator) {
      return decorator(target, property, desc) || desc;
   }, desc);

   if (context && desc.initializer !== void 0) {
      desc.value = desc.initializer ? desc.initializer.call(context) : void 0;
      desc.initializer = undefined;
   }

   if (desc.initializer === void 0) {
      Object['define' + 'Property'](target, property, desc);
      desc = null;
   }

   return desc;
}

function _initializerWarningHelper(descriptor, context) {
   throw new Error('Decorating class property failed. Please ensure that transform-class-properties is enabled.');
}

var Metadata = (_dec = _mobx.observable.shallow, (_class = function () {
   function Metadata() {
      _classCallCheck(this, Metadata);

      _initDefineProp(this, 'metadata', _descriptor, this);

      _initDefineProp(this, 'developers', _descriptor2, this);
   }

   _createClass(Metadata, [{
      key: 'addToDevelopers',
      value: function addToDevelopers(developer) {
         this.developers.push(developer);
      }
   }]);

   return Metadata;
}(), (_descriptor = _applyDecoratedDescriptor(_class.prototype, 'metadata', [_mobx.observable], {
   enumerable: true,
   initializer: function initializer() {
      return {
         "code_id": '',
         "site_ownership_code": '',
         "open_source": '',
         "repository_link": '',
         "originating_research_organizations": '',
         "software_title": '',
         "acronym": '',
         "doi": '',
         "description": '',
         "related_identifiers": '',
         "country_of_origin": '',
         "keywords": '',
         "disclaimers": '',
         "license": '',
         "recipient_name": '',
         "recipient_email": '',
         "recipient_phone": '',
         "recipient_org": '',
         "site_accession_number": '',
         "other_special_requirements": '',
         "related_software": ''
      };
   }
}), _descriptor2 = _applyDecoratedDescriptor(_class.prototype, 'developers', [_dec], {
   enumerable: true,
   initializer: function initializer() {
      return [];
   }
})), _class));
exports.default = Metadata;