package me.bdabrowski.wfs.restservice.controller;


import me.bdabrowski.wfs.restservice.model.JobOpening;
import me.bdabrowski.wfs.restservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobOpeningController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping()
    public ResponseEntity<List<JobOpening>> selectAllJobs(){
        List<JobOpening> openings = jobRepository.findAll();
        if(openings.size() != 0){
            return new ResponseEntity<>(openings,HttpStatus.OK );
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
