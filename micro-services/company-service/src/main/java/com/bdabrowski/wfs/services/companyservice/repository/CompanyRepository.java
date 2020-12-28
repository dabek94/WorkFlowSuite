package com.bdabrowski.wfs.services.companyservice.repository;

import com.bdabrowski.wfs.services.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
