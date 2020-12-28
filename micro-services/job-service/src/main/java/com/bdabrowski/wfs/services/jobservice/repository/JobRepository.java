package com.bdabrowski.wfs.services.jobservice.repository;


import com.bdabrowski.wfs.services.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  JobRepository extends JpaRepository<Job, Long> {
}
