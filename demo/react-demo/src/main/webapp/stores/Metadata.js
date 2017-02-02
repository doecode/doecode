import {observable} from 'mobx';

export default class Metadata {
    @observable metadata = {
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
    }

    addToDevelopers(developer) {
        developer.index = this.metadata.developers.length;
        developer.place = this.metadata.developers.length + 1;
        this.metadata.developers.push(developer);
    }

    removeDeveloper(developer) {
        const deletedPlace = developer.place;
        this.metadata.developers.remove(developer);

        for (var i = 0; i < this.metadata.developers.length; i++) {
            this.metadata.developers[i].index = i;

            if (this.metadata.developers[i].place > deletedPlace)
                this.metdata.developers[i].place--;
            }
        }

    modifyDeveloper(developer) {
        this.metadata.developers[developer.index] = developer;
    }

    updateDeveloperPlace(developer) {
        const prevPlace = this.metadata.developers[developer.index].place;
        const newPlace = developer.place;

        const check = newPlace > prevPlace;

        for (var i = 0; i < this.metadata.developers.length; i++) {
            if (check && this.metadata.developers[i] < newPlace) {
                this.metadata.developers[i].place--;
            } else if (!check && this.metadata.developers[i] > newPlace) {
                this.metadata.developers[i].place++;
            }
        }

        this.metadata.developers[developer.index].place = newPlace;
    }

}
