"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _desc, _value, _class, _descriptor, _descriptor2;

var _mobx = require("mobx");

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

var Metadata = (_class = function () {
    function Metadata() {
        _classCallCheck(this, Metadata);

        _initDefineProp(this, "metadata", _descriptor, this);

        _initDefineProp(this, "finished", _descriptor2, this);
    }

    _createClass(Metadata, [{
        key: "updateMetadata",
        value: function updateMetadata(data) {
            var oldRepo = new String(this.metadata.repository_link);
            data.repository_link = oldRepo;
            this.metadata = data;
        }
    }, {
        key: "addToDevelopers",
        value: function addToDevelopers(developer) {
            developer.place = this.metadata.developers.length + 1;
            this.metadata.developers.push(developer);
        }
    }, {
        key: "removeDeveloper",
        value: function removeDeveloper(developer) {
            var deletedPlace = developer.place;
            var index = this.metadata.developers.findIndex(function (item) {
                return item.place === developer.place;
            });
            this.metadata.developers.splice(index, 1);

            for (var i = 0; i < this.metadata.developers.length; i++) {

                if (this.metadata.developers[i].place > deletedPlace) this.metadata.developers[i].place--;
            }
        }
    }, {
        key: "modifyDeveloper",
        value: function modifyDeveloper(developer, previousPlace) {
            var index;
            if (developer.place != previousPlace) {
                index = this.updateDeveloperPlaceAndReturnIndex(developer, previousPlace);
            } else {
                index = this.metadata.developers.findIndex(function (item) {
                    return item.place === developer.place;
                });
            }

            if (index > -1) this.metadata.developers[index] = developer;
        }
    }, {
        key: "updateDeveloperPlaceAndReturnIndex",
        value: function updateDeveloperPlaceAndReturnIndex(developer, previousPlace) {
            var index = -1;
            var newPlace = developer.place;
            var check = newPlace > previousPlace;

            for (var i = 0; i < this.metadata.developers.length; i++) {
                if (check && this.metadata.developers[i].place <= newPlace && this.metadata.developers[i].place > previousPlace) {
                    this.metadata.developers[i].place--;
                } else if (!check && this.metadata.developers[i].place >= newPlace && this.metadata.developers[i].place < previousPlace) {
                    this.metadata.developers[i].place++;
                } else if (this.metadata.developers[i].place == previousPlace) {
                    this.metadata.developers[i].place = newPlace;
                    index = i;
                }
            }

            return index;
        }
    }]);

    return Metadata;
}(), (_descriptor = _applyDecoratedDescriptor(_class.prototype, "metadata", [_mobx.observable], {
    enumerable: true,
    initializer: function initializer() {
        return {
            "code_id": 0,
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
            "developers": [],
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
}), _descriptor2 = _applyDecoratedDescriptor(_class.prototype, "finished", [_mobx.observable], {
    enumerable: true,
    initializer: function initializer() {
        return false;
    }
})), _class);
exports.default = Metadata;