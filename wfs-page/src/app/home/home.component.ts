import {Component, OnInit} from '@angular/core';
import {UserService} from '../core/services/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../core/model/user.model';

@Component({
  selector: 'home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit{
  user: User;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute)  {
  }

  ngOnInit(): void {
    this.user = this.userService.getCurrentUser();
  }
}
