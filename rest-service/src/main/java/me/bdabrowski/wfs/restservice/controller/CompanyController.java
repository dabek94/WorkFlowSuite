package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("{id}")
    public ResponseEntity<Company> selectCompany(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id)
                .map(company -> ResponseEntity.ok().body(company))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        try {
            Company _company = companyRepository.save(company);
            return ResponseEntity.ok().body(_company);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

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
