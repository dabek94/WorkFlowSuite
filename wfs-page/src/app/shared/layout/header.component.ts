import {Component, OnInit} from '@angular/core';
import {UserService} from '../../core/services/user.service';
import {User} from '../../core/model/user.model';

@Component({
    selector: 'app-layout-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
  }
)
export class HeaderComponent implements OnInit{
  constructor(
    private userService: UserService
  ) {}

  currentUser: User;

  ngOnInit(): void {
    this.userService.currentUser.subscribe(
      (userData) => {
        this.currentUser = userData;
      }
    );
  }
}
