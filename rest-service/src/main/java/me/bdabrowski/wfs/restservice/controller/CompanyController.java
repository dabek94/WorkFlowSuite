package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A controller class for host:port/companies base endpoint of the service
 */
@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompanyController {
    /**
     * instance of CompanyRepository Interface assigned by Spring Context Dependency Injection
     */
    @Autowired
    CompanyRepository companyRepository;

    /**
     * GET request listener to endpoint host:port/companies/{id} that searches for the company based on id attribute
     *
     * @param id id of desired company
     * @return JSON representation of company if company with given param id exists in database
     * or 302 status code if company does not exist
     */
    @GetMapping("{id}")
    public ResponseEntity<Company> selectCompany(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id)
                .map(company -> ResponseEntity.ok().body(company))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST request listener to endpoint host:port/companies used to create new Company
     *
     * @param company new Company values matching the entity scheme, given in the request body as JSON
     * @return JSON representation of company if adding company to database was successful,
     * otherwise returns 417 status code
     */
    @PostMapping()
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        try {
            Company _company = companyRepository.save(company);
            return ResponseEntity.ok().body(_company);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * PUT request listener to endpoint host:port/companies/update/{id} responsible for updating the specific Company
     * based on given id
     *
     * @param updatedCompany new Company values matching the entity scheme, given in the request body as JSON
     * @param id             id of company for an update
     * @return JSON representation of company if updating company in database was successful, otherwise
     * returns 417 status code
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company updatedCompany,
                                                 @PathVariable(value = "id") Long id) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setName(updatedCompany.getName());
                    company.setOwner_id(updatedCompany.getOwner_id());
                    companyRepository.save(company);
                    return ResponseEntity.ok().body(company);
                }).orElse(ResponseEntity.notFound().build());
    }
}
