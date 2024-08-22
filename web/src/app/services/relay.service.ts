import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Relay } from './data/relay';

@Injectable()
export class RelayService {
    constructor(private http: HttpClient) {
    }

    getAll(): Observable<Relay[]> {
        return this.http.get<Relay[]>('api/relays');
    }

    updateState(id: number, state: boolean): Observable<void> {
        return this.http.put<void>('api/relays/'+id+'?state='+state, {});
    }
}
