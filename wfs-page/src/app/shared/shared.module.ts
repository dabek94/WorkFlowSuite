import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ShowAuthedDirective} from './show-authed.directive';
import {ShowCompanyDirective} from './show-company.directive';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
  ],
  declarations: [ShowAuthedDirective, ShowCompanyDirective],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    ShowAuthedDirective,
    ShowCompanyDirective
   ]
})
export class SharedModule{
}
