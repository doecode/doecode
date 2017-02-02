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
        developer.place = this.metadata.developers.length + 1;
        this.metadata.developers.push(developer);
    }

    removeDeveloper(developer) {
        const deletedPlace = developer.place;
        const index = this.metadata.developers.findIndex(item => item.place === developer.place);
        this.metadata.developers.splice(index, 1);

        for (var i = 0; i < this.metadata.developers.length; i++) {

            if (this.metadata.developers[i].place > deletedPlace)
                this.metadata.developers[i].place--;
            }
        }

    modifyDeveloper(developer, previousPlace) {
    	if (developer.place != previousPlace) {
    		this.updateDeveloperPlace(developer,previousPlace);
    	}
    	const index = this.metadata.developers.findIndex(item => item.place === developer.place);
        this.metadata.developers[index] = developer;
    }

    updateDeveloperPlace(developer, previousPlace) {
    	const index = this.metadata.developers.findIndex(item => item.place === previousPlace);
        const newPlace = developer.place;
        	
        const check = newPlace > previousPlace;

        for (var i = 0; i < this.metadata.developers.length; i++) {
            if (check && this.metadata.developers[i].place <= newPlace && this.metadata.developers[i].place  > previousPlace) {
                this.metadata.developers[i].place--;
            } else if (!check && this.metadata.developers[i].place >= newPlace && this.metadata.developers[i].place  < previousPlace) {
                this.metadata.developers[i].place++;
            }
        }

        this.metadata.developers[index].place = newPlace;
    }

}
