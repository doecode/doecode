import {observable} from 'mobx';

export default class Developer {

    @observable developer = {
        first_name: '',
        middle_name: '',
        last_name: '',
        email: '',
        affiliations: '',
        place: 0
    }

    @observable showModal = false;
    
    @observable isEdit = false;
    
    @observable previousPlace = -1;
    

    clear() {
      for (var field in this.developer)
          this.developer[field] = "";
    }
}
