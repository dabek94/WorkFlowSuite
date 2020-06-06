import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';
import {NewUser} from '../sign-up/sign-up.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = 'http://192.168.0.136:8080/users/';

  constructor(private http: HttpClient) { }

  getUserByEmailAndPassword(email: string, password: string){
    return this.http.post<User>(this.BASE_URL + email + '/' + password, null);
  }

  getAllEmployees(companyId: number): Observable<User[]>{
    return this.http.get<User[]>(this.BASE_URL + companyId);
  }
  createUser(newUser: User){
    return this.http.post<User>(this.BASE_URL, newUser);
  }
}
