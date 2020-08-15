import { Component, OnInit } from '@angular/core';
import {JobOpening} from '../../core/model/JobOpening';
import {JobService} from '../../shared/job.service';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrls: ['./job-listing.component.css']
})
export class JobListingComponent implements OnInit {

  jobs: JobOpening [] = [];

  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.getAllJobs();
  }

  public getAllJobs(){
    this.jobService.getAllJobs().subscribe(
      res => {
        this.jobs = res;
      }, error => {
        alert('error while getting jobs');
      }
    );
  }

}
