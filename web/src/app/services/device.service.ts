import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class DeviceService {
    constructor(private http: HttpClient) {
    }

    update(): Observable<number> {
        return this.http.post<number>('api/devices/update', null);
    }

    autodisable(): Observable<void> {
        return this.http.post<void>('api/devices/autodisable', null);
    }

}
