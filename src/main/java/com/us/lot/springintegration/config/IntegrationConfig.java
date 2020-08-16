package com.us.lot.springintegration.config;

import com.us.lot.springintegration.resource.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.messaging.MessageChannel;

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
    public MessageChannel receiverChannel(){
        return new DirectChannel();
    }

//    @Bean
//    public MessageChannel replyChannel(){
//        return new DirectChannel();
//    }

    @Filter(inputChannel = "router.channel")
    @Bean
    public MessageFilter filter(){
        MessageFilter filter = new MessageFilter(message -> message.getPayload() instanceof Student);
        filter.setOutputChannelName("student.channel");
        return filter;
    }
}
