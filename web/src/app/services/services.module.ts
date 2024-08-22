import {NgModule} from '@angular/core';
import {DashboardService} from './dashboard.service';
import { SensorService } from './sensor.service';
import { DeviceService } from './device.service';
import { RelayService } from './relay.service';


@NgModule({
    providers: [DashboardService, SensorService, RelayService, DeviceService],
})
export class ServicesModule {
}
