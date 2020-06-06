import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-navigation-signed',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  user: User = JSON.parse(localStorage.getItem('user'));

  constructor() { }

  ngOnInit(): void {
  }
  signOut(){
    localStorage.removeItem('user');
  }

}
