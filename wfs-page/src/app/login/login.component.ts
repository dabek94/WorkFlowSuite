import { Component, OnInit } from '@angular/core';
import {UserService} from '../shared/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  constructor(userService: UserService) { }

  ngOnInit(): void {
    const

  }
}
export interface User{
  email: string;
  password: string;
}
