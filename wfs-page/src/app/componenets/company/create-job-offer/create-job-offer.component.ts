import { Component, OnInit } from '@angular/core';
import {JobOpening} from '../../../core/model/JobOpening';
import {JobService} from '../../../shared/job.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-job-offer',
  templateUrl: './create-job-offer.component.html',
  styleUrls: ['./create-job-offer.component.css']
})
export class CreateJobOfferComponent implements OnInit {

  jobOffer: JobOpening = {
    id: null,
    companyId: 1,
    position: null,
    shortDescription: null
  };
  constructor(private jobService: JobService, private router: Router) { }

  ngOnInit(): void {
  }
  createJobOffer(jobOffering: JobOpening): void{
    this.jobService.createJobOffer(jobOffering).subscribe(
      res => {
        alert('user created');
        this.router.navigate(['/jobs']);
      }, error => {
        alert('error');
      }
    );
  }

}
