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
    "developers" : [],
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

  // @observable developers = [];
   addToDevelopers(developer) {
     this.metadata.developers.push(developer);
   }


}
