import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../core/services/user.service';

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  authType: string = '';
  title: string = '';
  isSubmitting = false;
  authForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private fb: FormBuilder
  ) {
    this.authForm = this.fb.group({
      'email': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  ngOnInit() {
    this.route.url.subscribe(data => {
      // Get the last piece of the URL (it's either 'login' or 'register')
      this.authType = data[data.length - 1].path;
      // Set a title for the page accordingly
      this.title = (this.authType === 'login') ? 'Sign in' : 'Sign up';
      // add form control for username if this is the register page
      if (this.authType === 'register') {
        this.authForm.addControl('username', new FormControl());
      }
    });

  }

  submitForm() {
    this.isSubmitting = true;
    const credentials = this.authForm.value;
    this.userService
      .attemptAuth(this.authType, credentials)
      .subscribe(
        data => {
          this.router.navigateByUrl('/home');
        },
        err => {
          console.log('error');
          this.isSubmitting = false;
        }
      );
  }
}
