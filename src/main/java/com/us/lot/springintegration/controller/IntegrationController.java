package com.us.lot.springintegration.controller;

import com.us.lot.springintegration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/{name}")
    public String getMessageFormatIntegrationService(@PathVariable String name){
        return integrationGateway.sendMessage(name);
    }

}
