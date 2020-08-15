import { Component, OnInit } from '@angular/core';
import {User} from '../../../core/model/user';
import {Address} from '../../../core/model/Address';
import {UserService} from '../../../shared/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-account-update',
  templateUrl: './account-update.component.html',
  styleUrls: ['./account-update.component.css']
})
export class AccountUpdateComponent implements OnInit {
  user: User = JSON.parse(localStorage.getItem('user'));

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  public changeEmail(newEmail: string){
    this.user.email = newEmail;
    return this.userService.updateEmail(this.user, this.user.id).subscribe(
      res => {
        localStorage.setItem('user', JSON.stringify(res));
        this.router.navigate(['/account']);
      }, error => {
        alert('error');
    });
  }
  public changePassword(newPassword: string){
    this.user.password = newPassword;
    return this.userService.updatePassword(this.user, this.user.id).subscribe(
      res => {
        localStorage.setItem('user', JSON.stringify(res));
        this.router.navigate(['/account']);
      }, error => {
        alert('error');
      });
  }
  public changeAddress(newStreet: string, newCity: string, newState: string,
                       newZipCode: string, newCountry: string){
    this.user.address.street = newStreet;
    this.user.address.city = newCity;
    this.user.address.state = newState;
    this.user.address.zipCode = newZipCode;
    this.user.address.country = newCountry;
    return this.userService.updateAddress(this.user.address, this.user.id).subscribe(
      res => {
        this.user.address = res;
        localStorage.setItem('user', JSON.stringify(this.user));
        this.router.navigate(['/account']);
      }, error => {
        alert('error');
      });
  }
}

