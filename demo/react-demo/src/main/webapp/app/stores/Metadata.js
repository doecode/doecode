import {observable} from 'mobx';

export default class Metadata {
    @observable metadata = {
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
        "contributors": [],
        "sponsoring_organizations" : [],
        "contributing_organizations" : [],
        "research_organizations" : [],
        "identifiers" : [],
        "date_of_issuance" : "",
        "keywords": '',
        "disclaimers": '',
        "licenses": [],
        "recipient_name": '',
        "recipient_email": '',
        "recipient_phone": '',
        "recipient_org": '',
        "site_accession_number": '',
        "other_special_requirements": '',
        "related_software": '',
        "access_limitations": []
        
    }

    @observable finished = false;
    
    updateMetadata(data) {
    	const oldRepo = new String(this.metadata.repository_link);
    	data.repository_link = oldRepo;
    	this.metadata = data;
    	
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
        var index;
        if (developer.place != previousPlace) {
            index = this.updateDeveloperPlaceAndReturnIndex(developer, previousPlace);
        } else {
            index = this.metadata.developers.findIndex(item => item.place === developer.place);
        }

        if (index > -1)
            this.metadata.developers[index] = developer;
        }

    updateDeveloperPlaceAndReturnIndex(developer, previousPlace) {
        var index = -1;
        const newPlace = developer.place;
        const check = newPlace > previousPlace;

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

}
