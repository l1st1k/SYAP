package com.example.syap_spring.request_history;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Module customSerializerModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(RequestHistory.class, new RequestHistorySerializer());
        return module;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(customSerializerModule());
        return mapper;
    }
}

