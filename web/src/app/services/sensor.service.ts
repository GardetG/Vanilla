import {Sensor} from './data/sensor';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class SensorService {
    constructor(private http: HttpClient) {
    }

    getAll(): Observable<Sensor[]> {
        return this.http.get<Sensor[]>('api/sensors');
    }

    updateState(id: number, state: boolean): Observable<void> {
        return this.http.put<void>('api/sensors/'+id+'?state='+state, {});
    }
}
