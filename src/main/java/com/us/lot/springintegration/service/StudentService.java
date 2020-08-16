package com.us.lot.springintegration.service;

import com.us.lot.springintegration.resource.Student;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Component
public class StudentService {

    @ServiceActivator(inputChannel = "student.channel")
    public void receiveMessage(Message<?> message) {
        System.out.println("########student.channel########");
        System.out.println(message);
        System.out.println("################");
        System.out.println("Object to json - " + message.getPayload());
    }

}
