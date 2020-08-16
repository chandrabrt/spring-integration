package com.us.lot.springintegration.config;

import com.us.lot.springintegration.resource.Address;
import com.us.lot.springintegration.resource.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

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

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "router.channel")
    @Bean
    public PayloadTypeRouter router(){
        PayloadTypeRouter router = new PayloadTypeRouter();
        router.setChannelMapping(Student.class.getName(), "student.enrich.header.channel");
        router.setChannelMapping(Address.class.getName(), "address.enrich.header.channel");
        return router;
    }

    //adding custom headers
    @Bean
    @Transformer(inputChannel = "student.enrich.header.channel",
            outputChannel = "header.payload.router.channel")
    public HeaderEnricher enrichHeaderForStudent(){
        Map<String, HeaderValueMessageProcessor<String>> headersToAdd = new HashMap<>();
        headersToAdd.put("testHeader", new StaticHeaderValueMessageProcessor<>("student"));
        return new HeaderEnricher(headersToAdd);
    }

    @Bean
    @Transformer(inputChannel = "address.enrich.header.channel",
            outputChannel = "header.payload.router.channel")
    public HeaderEnricher enrichHeaderForAddress(){
        Map<String, HeaderValueMessageProcessor<String>> headersToAdd = new HashMap<>();
        headersToAdd.put("testHeader", new StaticHeaderValueMessageProcessor<>("address"));
        return new HeaderEnricher(headersToAdd);
    }

   @ServiceActivator(inputChannel = "header.payload.router.channel")
    @Bean
    public HeaderValueRouter headerValueRouter(){
        HeaderValueRouter router = new HeaderValueRouter("testHeader");
        router.setChannelMapping("student", "student.channel");
        router.setChannelMapping("address", "address.channel");
        return router;
   }

}
