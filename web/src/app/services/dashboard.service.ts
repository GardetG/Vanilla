import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class DashboardService {
    constructor(private http: HttpClient) {
    }

    load(): Observable<string> {
        return this.http
            .get('api/status', {responseType: 'text'});
    }
}
