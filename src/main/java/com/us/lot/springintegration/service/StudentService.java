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

    @ServiceActivator(inputChannel = "integration.student.objectToJson.channel",
            outputChannel = "integration.student.jsonToObject.channel")
    public Message<?> receiveMessage(Message<?> message) {
        System.out.println("################");
        System.out.println(message);
        System.out.println("################");
        System.out.println("Object to json - " + message.getPayload());
        return message;
    }

    @ServiceActivator(inputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    public void processJsonToObject(Message<?> message){
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        System.out.println("#################");
        System.out.println("Json to Object - " +message.getPayload());
        System.out.println("#################");
        Student student = (Student) message.getPayload();
        Message<?> newMessage = MessageBuilder.withPayload(student.toString()).build();
        if (Objects.nonNull(replyChannel)) {
            replyChannel.send(newMessage);
        }
    }

}
