import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../shared/user.service';
import {Router} from '@angular/router';
import {User} from '../../core/model/user';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user: User = {
    id: null,
    email: null,
    password: null,
    firstName: null,
    lastName: null,
    userType: null,
    companyId: null,
    address: null
  };
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

   createUser(userViewModel: User): void{
    this.userService.createUser(userViewModel).subscribe(
      res => {
        alert('user created');
        this.user = res;
        localStorage.setItem('user', JSON.stringify(this.user));
        this.router.navigate(['/jobs']);
      }, error => {
        alert('error');
      }
    );
  }
}
export interface NewUser {
  email: string;
  password: string;
}
