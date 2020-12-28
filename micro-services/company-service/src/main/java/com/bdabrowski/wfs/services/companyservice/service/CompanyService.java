package com.bdabrowski.wfs.services.companyservice.service;

import com.bdabrowski.wfs.services.companyservice.model.Company;
import com.bdabrowski.wfs.services.companyservice.repository.CompanyRepository;
import com.bdabrowski.wfs.services.companyservice.wrapper.ResponseWrapper;
import com.bdabrowski.wfs.services.companyservice.wrapper.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepostory;

    @Autowired
    private RestTemplate restTemplate;


    public Company saveCompany(Company company) {
        log.info("Inside saveCompany of CompanyService");
        return companyRepostory.save(company);
    }

    public Company findCompanyByCompanyId(Long companyId) {
        log.info("Inside findCompanyByCompanyId of CompanyService");
        return companyRepostory.findById(companyId).orElse(new Company());

    }

    public ResponseWrapper getCompanyWithEmployees(Long companyId) {
        log.info("Inside getCompanyWithEmployees of CompanyService");
        ResponseWrapper responseWrapper = new ResponseWrapper();
        Company company = companyRepostory
                            .findById(companyId)
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<User> users = restTemplate.getForObject("http://USER-SERVICE/user/employees/" + company.getId(), List.class);

        responseWrapper.setCompany(company);
        responseWrapper.setEmployees(users);

        return responseWrapper;
    }
}
