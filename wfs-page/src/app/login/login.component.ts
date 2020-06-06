import { Component, OnInit } from '@angular/core';
import {UserService} from '../shared/user.service';
import {User} from '../model/user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = {
    id: null,
    email: null,
    password: null,
    firstName: null,
    lastName: null,
    userType: null,
    companyId: null
  };
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  public login(email: string, password: string){
    return this.userService.getUserByEmailAndPassword(email, password).subscribe(
      res => {
        this.user = res;
        localStorage.setItem('user', JSON.stringify(this.user));
        this.router.navigate(['/']);
      }, error => {
        alert('incorrect information');
      }
    );
  }

}
