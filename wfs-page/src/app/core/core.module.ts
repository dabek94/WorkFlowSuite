import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {JwtService} from './services/jwt.service';
import {UserService} from './services/user.service';
import {ApiService} from './services/api.service';
import {HttpTokenInterceptor} from './interceptors/http.token.interceptor';
import {HTTP_INTERCEPTORS} from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpTokenInterceptor, multi: true },
    ApiService,
    UserService,
    JwtService
  ],
  declarations: []
})
export class CoreModule { }
