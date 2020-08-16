package com.us.lot.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Component
public class StudentService {

    @ServiceActivator(inputChannel = "student.channel.1")
    public void receiveMessage1(Message<?> message) {
        System.out.println("########student.channel.1########");
        System.out.println(message);
        System.out.println("################");
        System.out.println(message.getPayload());
    }

    @ServiceActivator(inputChannel = "student.channel.2")
    public void receiveMessage2(Message<?> message) {
        System.out.println("########student.channel.2########");
        System.out.println(message);
        System.out.println("################");
        System.out.println(message.getPayload());
    }

}
