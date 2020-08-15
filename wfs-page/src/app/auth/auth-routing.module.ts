import {Router, RouterModule, Routes} from '@angular/router';
import {AuthComponent} from './auth.component';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {
    path: 'login',
    component: AuthComponent
  },
  {
    path: 'register',
    component: AuthComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule{
}
