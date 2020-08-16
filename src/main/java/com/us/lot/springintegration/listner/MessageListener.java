package com.us.lot.springintegration.listner;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Component
public class MessageListener {

    private final JedisConnectionFactory jedisConnectionFactory;

    public MessageListener(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "redisChannel")
    public Message<?> receiverFromService(Message<?> message){
        System.out.println("received from service");
        return message;
    }

    @ServiceActivator(inputChannel = "redisChannel")
    public void sendMessageToQueue(Message<?> message){
        RedisQueueOutboundChannelAdapter adapter = new RedisQueueOutboundChannelAdapter(
                "Redis-Queue",jedisConnectionFactory);
        adapter.handleMessage(message);
    }

    @ServiceActivator(inputChannel = "receiveChannel")
    public void receiverFromQueue(Message<?> message){
        System.out.println("received from redis-queue "+ message);
    }
}
