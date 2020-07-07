package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * A repository API for JobOpening Entity.
 * CRUD operations nn Spring Data JPARepository
 */
public interface JobRepository extends JpaRepository<JobOpening, Long> {


}
