import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = 'http://localhost:8080/users/';

  constructor(private http: HttpClient) { }

  getAllEmployees(companyId: number): Observable<User[]>{
    return this.http.get<User[]>(this.BASE_URL + companyId);
  }

}
