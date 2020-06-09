import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmployeesComponent } from './employees/employees.component';
import {Router, RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { IndexComponent } from './index/index.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {HttpClientModule} from '@angular/common/http';
import { AccountComponent } from './account/account.component';
import {NavigationUnsignedComponent} from './header/navigation_unsigned/navigation-unsigned.component';
import {NavigationComponent} from './header/navigation/navigation.component';
import { AccountUpdateComponent } from './account-update/account-update.component';

const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: 'employees',
    component: EmployeesComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signUp',
    component: SignUpComponent
  },
  {
    path: 'account',
    component: AccountComponent
  },
  {
    path: 'account/update',
    component: AccountUpdateComponent
  }

];

@NgModule({
  declarations: [
    AppComponent,
    NavigationUnsignedComponent,
    NavigationComponent,
    LoginComponent,
    SignUpComponent,
    IndexComponent,
    EmployeesComponent,
    AccountComponent,
    AccountUpdateComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
