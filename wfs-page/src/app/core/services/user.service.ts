import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {JwtService} from './jwt.service';
import {HttpClient} from '@angular/common/http';
import {distinctUntilChanged, map} from 'rxjs/operators';
import {User} from '../model/user.model';
import {BehaviorSubject, Observable, ReplaySubject} from 'rxjs';

@Injectable()
export class UserService {
  private currentUserSubject = new BehaviorSubject<User>({} as User);
  public currentUser = this.currentUserSubject.asObservable().pipe(distinctUntilChanged());

  private isAuthenticatedSubject = new ReplaySubject<boolean>(1);
  public isAuthenticated = this.isAuthenticatedSubject.asObservable();

  private isEmployedSubject = new ReplaySubject<boolean>(1);
  public isEmployed = this.isEmployedSubject.asObservable();

  constructor(
    private apiService: ApiService,
    private http: HttpClient,
    private jwtService: JwtService
  ) {
  }
// This runs once on application startup.
  populate() {
    // If JWT detected, attempt to get & store user's info
    if (this.jwtService.getToken()) {
      this.apiService.get('/users/login')
        .subscribe(
          data => this.setAuth(data.user),
          err => this.purgeAuth()
        );
    } else {
      // Remove any potential remnants of previous auth states
      this.purgeAuth();
    }
  }
  purgeAuth() {
    // Remove JWT from localstorage
    this.jwtService.destroyToken();
    // Set current user to an empty object
    this.currentUserSubject.next({} as User);
    // Set auth status to false
    this.isAuthenticatedSubject.next(false);
    // Set employment status to false
    this.isEmployedSubject.next(false);
  }
  attemptAuth(type, credentials) {
    const route = (type === 'login') ? '/login' : '';
    return this.apiService.post('/users' + route, credentials)
      .pipe(map(data => {
          this.setAuth(data.user);
          return data;
        }
      ));
  }
  setAuth(user: User){
    // Save JWT sent from server in localstorage
    // @ts-ignore
    this.jwtService.saveToken(user.token);
    // Set current user data into observable
    this.currentUserSubject.next(user);
    // Set isAuthenticated to true
    this.isAuthenticatedSubject.next(true);
    // tslint:disable-next-line:triple-equals
    if (user.company != undefined){
      this.isEmployedSubject.next(true);
    } else {
      this.isEmployedSubject.next(false);
    }
  }
  getCurrentUser(): User {
    console.log(this.currentUserSubject.value);
    return this.currentUserSubject.value;
  }
// Update the user on the server (email, pass, etc)
  update(user): Observable<User> {
    return this.apiService
      .put('/user', { user })
      .pipe(map(data => {
        // Update the currentUser observable
        this.currentUserSubject.next(data.user);
        return data.user;
      }));
  }

}
