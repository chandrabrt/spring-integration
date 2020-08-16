package com.us.lot.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;

/**
 * @author chandra khadka
 * @since 2020-08-16
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {
    /**
     * @EnableIntegration: is useful when you have multiple config files in your application along with spring integration
     * configurations
     * @IntegrationComponentScan: used for class path scaling just like @ComponentScan, but restricted to integration components
     * where @ComponentScan cannot reach
     * DirectChannel - acts like a point to point channel and is the simplest
     */

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        //return default connectivity
        return new JedisConnectionFactory();
    }
    @Bean
    public DirectChannel receiverChannel(){
        return new DirectChannel();
    }

    @Bean
    public RedisQueueMessageDrivenEndpoint consumerEndPoint(){
        RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint("Redis-Queue",
                jedisConnectionFactory());
        endpoint.setOutputChannelName("receiveChannel");
        return endpoint;
    }
}
