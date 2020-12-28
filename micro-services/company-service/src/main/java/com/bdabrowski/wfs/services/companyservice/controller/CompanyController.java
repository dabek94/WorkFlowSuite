package com.bdabrowski.wfs.services.companyservice.controller;

import com.bdabrowski.wfs.services.companyservice.model.Company;
import com.bdabrowski.wfs.services.companyservice.service.CompanyService;
import com.bdabrowski.wfs.services.companyservice.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public Company saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }
    @GetMapping("/{id}")
    public Company selectCompanyById(@PathVariable("id") Long companyId){
        return companyService.findCompanyByCompanyId(companyId);
    }

    @GetMapping("/{id}/employees")
    public ResponseWrapper getCompanyWithEmployees(@PathVariable("id") Long companyId){
        return companyService.getCompanyWithEmployees(companyId);
    }


}
