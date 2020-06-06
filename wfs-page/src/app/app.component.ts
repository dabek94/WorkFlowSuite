import { Component } from '@angular/core';
import {User} from './model/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user: User = JSON.parse(localStorage.getItem('user'));

  isLoggedIn(): boolean{
    if (localStorage.getItem('user') == null) {
      return false;
    }
    else {
      this.user = JSON.parse(localStorage.getItem('user'));
      return true;
    }
  }
  isEmployee(): boolean{
    if (this.user.userType.localeCompare('Employee')){
      return true;
    } else {
      return false;
    }
  }

}
