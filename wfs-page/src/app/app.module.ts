import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HeaderComponent} from './shared/layout/header.component';
import {FooterComponent} from './shared/layout/footer.component';
import {SharedModule} from './shared/shared.module';
import {CoreModule} from './core/core.module';
import {AuthModule} from './auth/auth.module';
import {HomeModule} from './home/home.module';
import {IndexModule} from './index/index.module';
import {SettingsModule} from './settings/settings.module';

@NgModule({
  declarations: [
    AppComponent, HeaderComponent, FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    SharedModule,
    IndexModule,
    AuthModule,
    HomeModule,
    SettingsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
