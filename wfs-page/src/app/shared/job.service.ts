import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  // TODO Implement ${BASE_URL/path}, the injection doesnt work for some reason
  private BASE_URL = 'http://192.168.1.14:8080/jobs/';

  constructor(private http: HttpClient) { }

  getAllJobs(){
    return this.http.get(this.BASE_URL);
  }
}
