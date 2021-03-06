package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.model.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
