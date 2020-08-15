package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping(value = "{id}", headers = "WFS-API-VERSION=1")
    public ResponseEntity<Company> selectCompany(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id)
                .map(company -> ResponseEntity.ok().body(company))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(headers = "WFS-API-VERSION=1")
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
    @GetMapping("/getEmployees/{id}")
    public ResponseEntity<List<User>> getAllEmployees(@PathVariable(value = "id") Long id){
        return companyRepository.findById(id)
                .map(company -> ResponseEntity.ok().body(company.getEmployees()))
                .orElse(ResponseEntity.notFound().build());
    }
}
