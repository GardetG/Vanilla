import {Component, OnInit} from '@angular/core';
import {DashboardService} from '../../services/dashboard.service';
import { Sensor } from '../../services/data/sensor';
import { SensorService } from '../../services/sensor.service';
import { DeviceService } from '../../services/device.service';
import { Relay } from '../../services/data/relay';
import { RelayService } from '../../services/relay.service';


@Component({
    selector: 'ngx-dashboard',
    templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {
    message = 'HS';
    sensors: Sensor[] = [];
    relays: Relay[] = [];
    duration: string = null;

    constructor(
        private dashboardService: DashboardService,
        private sensorService: SensorService,
        private relayService: RelayService,
        private deviceService: DeviceService
    ) {
    }

    ngOnInit() {
        this.load();
    }

    load(): void {
        this.dashboardService.load().subscribe(message => this.message = message);
        this.sensorService.getAll().subscribe(sensors => this.sensors = sensors);
        this.relayService.getAll().subscribe(relays => this.relays = relays);
    }

    autodisable(): void {
        this.deviceService.autodisable().subscribe();
        this.load();
    }

    update(): void {
        this.duration = 'En cours...'
        this.deviceService.update().subscribe(duration => this.duration = duration + " secondes");
    }

    toogleSensor(sensor: Sensor) {
        this.sensorService.updateState(sensor.id, sensor.state).subscribe();
    }

    toogleRelay(relay: Relay) {
        this.relayService.updateState(relay.id, relay.state).subscribe();
    }

}
