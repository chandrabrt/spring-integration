package com.us.lot.springintegration.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Service;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Service
@MessagingGateway
public interface IntegrationGateway {
    /**
     * @MessagingGateway: it is an interface that serves as a proxy abstraction over the messaging structure
     * @Gateway: is usually annotated on the method signature inside the interface
     */
    //generic type gateway
    @Gateway(requestChannel = "inputChannel")
    <S> void sendMessage(S request);
}
