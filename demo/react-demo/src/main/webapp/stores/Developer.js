import {observable} from 'mobx';

export default class Developer {

    @observable developer = {
        first_name: '',
        middle_name: '',
        last_name: '',
        email: ''
    }

    @observable showModal = false;

    clear() {
      for (var field in this.developer)
          this.developer[field] = "";
    }
}
