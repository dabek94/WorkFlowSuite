import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigation-signed',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  signOut(){
    localStorage.removeItem('user');
  }

}
