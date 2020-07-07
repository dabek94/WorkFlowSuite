package me.bdabrowski.wfs.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Restful service for WorkFlowSuite platform.
 * The WFS platform allows companies to manage their
 *
 * UPDATE:
 * Version 0.3 will contain CQRS DTO in form of Projections with Spring Data JPA
 *
 * @author Bartosz Dabrowski
 * @since 23/03/2020
 * @version 0.2
 */

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
