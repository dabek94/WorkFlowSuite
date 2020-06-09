import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../../../model/user';
import {UserService} from '../../../shared/user.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllEmployees(1);
  }

  public getAllEmployees(companyId: number){
    this.userService.getAllEmployees(companyId).subscribe(
      res => {
        this.users = res;
      }, err => {
      alert('An error occured');
    }
    );
  }
}
