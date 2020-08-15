package me.bdabrowski.wfs.restservice.controller;


import me.bdabrowski.wfs.restservice.model.JobOpening;
import me.bdabrowski.wfs.restservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobOpeningController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping()
    public ResponseEntity<List<JobOpening>> selectAllJobs() {
        List<JobOpening> openings = jobRepository.findAll();
        if (openings.size() != 0) {
            return new ResponseEntity<>(openings, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{phrase}")
    public ResponseEntity<List<JobOpening>> selectJobsByPhrase(@PathVariable("phrase") String phrase){
        List<JobOpening> openings = jobRepository.findAll();
        if(openings.size() != 0){
            openings = openings.stream()
                    .filter(jobOpening -> jobOpening.getShortDescription().toLowerCase().contains(phrase.toLowerCase()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(openings);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

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
