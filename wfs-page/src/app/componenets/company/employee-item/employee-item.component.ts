import { Component, OnInit, Input} from '@angular/core';
import {User} from '../../../model/user';

@Component({
  selector: 'app-employee-item',
  templateUrl: './employee-item.component.html',
  styleUrls: ['./employee-item.component.css']
})
export class EmployeeItemComponent implements OnInit {
  @Input() employee: User;

  constructor() { }

  ngOnInit(): void {
  }

}
