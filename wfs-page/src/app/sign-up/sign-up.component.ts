import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../shared/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  model: UserViewModel = {
    email: 'asd',
    password: 'asd'
  };


  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

   createUser(userViewModel: UserViewModel): void{
    

  }

}
export interface UserViewModel {
  email: string;
  password: string;
}
