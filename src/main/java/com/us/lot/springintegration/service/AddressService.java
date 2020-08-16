package com.us.lot.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Component
public class AddressService {

    @ServiceActivator(inputChannel = "address.channel")
    public void receiveMessage(Message<?> message) {
        System.out.println("########address.channel########");
        System.out.println(message);
        System.out.println("################");
        System.out.println("Object to json - " + message.getPayload());
    }
}
