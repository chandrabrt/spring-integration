package com.us.lot.springintegration.service;

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
public class IntegrationService {
    /**
     *Message - Message is a generic wrapper for any Java object. It has the header and the payload.
     *Message Channel - it represents a pipe. messages are sent and received to and from a channel
     *@ServiceActivator - acts like a connecter between the spring managed object and the input channel
     */

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage(Message<String> message){
        //receive message from replyChannel
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        //business logic
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder
                .withPayload("Welcome, " + message.getPayload() + " to spring Integration").build();
        if (Objects.nonNull(replyChannel)){
            replyChannel.send(newMessage);
        }
    }
}
