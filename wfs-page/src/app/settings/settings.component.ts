import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../core/model/user.model';
import {UserService} from '../core/services/user.service';


@Component({
  selector: 'app-settings-page',
  templateUrl: './settings.component.html'
})
export class SettingsComponent implements OnInit {
  user: User;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute
    ) {}

  ngOnInit(): void {
    this.user = this.userService.getCurrentUser();
  }
}
