package me.bdabrowski.wfs.restservice.controller;


import me.bdabrowski.wfs.restservice.model.JobOpening;
import me.bdabrowski.wfs.restservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * A controller class for host:port/jobs base endpoint of the service
 */
@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobOpeningController {

    /**
     * instance of jobRepository Interface assigned by Dependency Injection
     */
    @Autowired
    JobRepository jobRepository;

    /**
     * GET request listener to endpoint host:port/jobs that returns all the jobs in the service
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<JobOpening>> selectAllJobs() {
        List<JobOpening> openings = jobRepository.findAll();
        if (openings.size() != 0) {
            return new ResponseEntity<>(openings, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * POST request listener to endpoint  host:port/jobs that creates new JobOpening
     *
     * @param jobOpening JobOpening values matching the entity scheme, given in the request body as JSON
     * @return JSON representation of company if adding jobOpening to database was successful,
     * otherwise returns 417 status code;
     */
    @PostMapping()
    public ResponseEntity<JobOpening> createJobOpening(@RequestBody JobOpening jobOpening) {
        try {
            jobOpening.setCreatedTime(new Date());
            JobOpening newJobOpening = jobRepository.save(jobOpening);
            return ResponseEntity.ok().body(newJobOpening);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }
  /*
    @PutMapping("/update/{id}")
    public ResponseEntity<JobOpening> updateJobOpening(@RequestBody JobOpening jobOpening, @PathVariable("id") Long id){
        Optional<JobOpening> existingJob = jobRepository.findById(id);

    }*/


}
