package com.bdabrowski.wfs.services.wfsgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking long than Expected." +
                " Please try again laster";
    }


    @GetMapping("/companyServiceFallBack")
    public String companyServiceFallBackMethod(){
        return "Company Service is taking long than Expected." +
                " Please try again laster";
    }

    @GetMapping("/jobServiceFallBack")
    public String jobServiceFallBackMethod(){
        return "Job Service is taking long than Expected." +
                " Please try again laster";
    }
}
