import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './componenets/login/login.component';
import { EmployeesComponent } from './componenets/company/employees/employees.component';
import {Router, RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { IndexComponent } from './componenets/index/index.component';
import { SignUpComponent } from './componenets/sign-up/sign-up.component';
import {HttpClientModule} from '@angular/common/http';
import { AccountComponent } from './componenets/account/account.component';
import {NavigationUnsignedComponent} from './componenets/header/navigation_unsigned/navigation-unsigned.component';
import {NavigationComponent} from './componenets/header/navigation/navigation.component';
import { AccountUpdateComponent } from './componenets/account/account-update/account-update.component';
import { EmployeeItemComponent } from './componenets/company/employee-item/employee-item.component';

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
    EmployeeItemComponent,
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
