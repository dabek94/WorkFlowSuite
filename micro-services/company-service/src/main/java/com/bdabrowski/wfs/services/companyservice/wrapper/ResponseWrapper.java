package com.bdabrowski.wfs.services.companyservice.wrapper;

import com.bdabrowski.wfs.services.companyservice.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper {

    private Company company;
    private List<User> employees;
}
