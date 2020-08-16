package com.us.lot.springintegration.controller;

import com.us.lot.springintegration.resource.Address;
import com.us.lot.springintegration.resource.Student;
import com.us.lot.springintegration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/integration")
public class IntegrationController {

    private final IntegrationGateway integrationGateway;

    @Autowired
    public IntegrationController(IntegrationGateway integrationGateway) {
        this.integrationGateway = integrationGateway;
    }

    @PostMapping("/student")
    public void processStudentDetails(@RequestBody Student student){
        integrationGateway.process(student);
    }

    @PostMapping("/address")
    public void processAddressDetails(@RequestBody Address address){
        integrationGateway.process(address);
    }

}
