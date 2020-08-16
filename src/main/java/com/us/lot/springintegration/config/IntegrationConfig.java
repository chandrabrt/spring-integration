package com.us.lot.springintegration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.us.lot.springintegration.resource.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
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

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

    //transformer
    @Bean
    @Transformer(inputChannel = "integration.student.gateway.channel",
            outputChannel = "integration.student.objectToJson.channel")
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());
    }

    @Bean
    public Jackson2JsonObjectMapper getMapper() {
        return new Jackson2JsonObjectMapper(new ObjectMapper());
    }

    @Bean
    @Transformer(inputChannel = "integration.student.jsonToObject.channel",
            outputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    public JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Student.class);
    }
}
