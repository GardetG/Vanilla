import {NgModule} from '@angular/core';
import {NbButtonModule, NbCardModule, NbToggleModule} from '@nebular/theme';

import {ThemeModule} from '../../@theme/theme.module';
import {DashboardComponent} from './dashboard.component';
import { ServicesModule } from '../../services/services.module';

@NgModule({
  imports: [
    NbCardModule,
    ThemeModule,
    ServicesModule,
    NbToggleModule,
    NbButtonModule,
  ],
  declarations: [
    DashboardComponent,
  ],
})
export class DashboardModule {
}
