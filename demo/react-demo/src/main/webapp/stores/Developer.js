import {observable} from 'mobx';

export default class Developer {

    @observable developer = {
        first_name: '',
        middle_name: '',
        last_name: '',
        email: '',
        place: 0,
        index: 0
    }

    @observable showModal = false;

    clear() {
      for (var field in this.developer)
          this.developer[field] = "";
    }
}
