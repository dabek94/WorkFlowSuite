package com.bdabrowski.wfs.services.jobservice.controller;

import com.bdabrowski.wfs.services.jobservice.model.Job;
import com.bdabrowski.wfs.services.jobservice.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public Job saveJob(@RequestBody Job job){
        log.info("Inside saveJob method of JobController");
        return jobService.saveJob(job);
    }

    @GetMapping("/{id}")
    public Job findJobByJobId(@PathVariable("id") Long jobId){
        log.info("Inside findJobById of JobController");
        return jobService.findJobByJobId(jobId);
    }
}
