package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobOpening, Long> {


}
