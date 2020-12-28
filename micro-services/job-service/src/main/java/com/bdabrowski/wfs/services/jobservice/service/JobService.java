package com.bdabrowski.wfs.services.jobservice.service;

import com.bdabrowski.wfs.services.jobservice.model.Job;
import com.bdabrowski.wfs.services.jobservice.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        log.info("Inside saveJob of JobService");
        return jobRepository.save(job);
    }

    public Job findJobByJobId(Long jobId) {
        log.info("Inside findJobById of JobService");
        return jobRepository.findById(jobId).orElse(new Job());

    }
}
