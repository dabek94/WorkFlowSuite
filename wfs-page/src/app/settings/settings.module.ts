import { NgModule } from '@angular/core';

import { SettingsComponent } from './settings.component';
import { SettingsRoutingModule } from './settings-routing.module';
import {SharedModule} from '../shared/shared.module';

@NgModule({
  imports: [SharedModule, SettingsRoutingModule],
  declarations: [SettingsComponent],
  exports: [SettingsComponent]
})
export class SettingsModule {}
