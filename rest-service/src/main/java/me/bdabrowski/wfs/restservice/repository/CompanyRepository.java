package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
