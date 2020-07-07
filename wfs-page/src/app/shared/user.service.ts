import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';
import {NewUser} from '../componenets/sign-up/sign-up.component';
import {Address} from '../model/Address';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = 'http://192.168.1.14:8080/users/';
  // TODO Implement ${BASE_URL/path}, the injection doesnt work for some reason
  private UPDATE_EMAIL_URL = 'http://192.168.1.14:8080/users/update/email/';
  private UPDATE_PASSWORD_URL = 'http://192.168.1.14:8080/users/update/password/';
  private UPDATE_ADDRESS_URL = 'http://192.168.1.14:8080/users/update/address/';

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
  updateEmail(updatedUser: User, id: bigint){
    return this.http.put<User>(this.UPDATE_EMAIL_URL + id, updatedUser);
  }
  updatePassword(updatedUser: User, id: bigint){
    return this.http.put<User>(this.UPDATE_PASSWORD_URL + id, updatedUser);
  }
  updateAddress(updatedAddress: Address, id: bigint){
    return this.http.put<Address>(this.UPDATE_ADDRESS_URL + id, updatedAddress);
  }
}
