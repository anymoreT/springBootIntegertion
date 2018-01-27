package com.hdw.springboot.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bysocket on 08/09/2017.
 */
@Configuration
@ConfigurationProperties(prefix = "my")
public class MessageConfiguration {
    private List<String> servers = new ArrayList<String>();

    Logger logger = Logger.getLogger(MessageConfiguration.class);

    public List<String> getServers() {
        return this.servers;
    }

    @Bean
    public String message() {
        logger.info("++++++++message configuration");
        return "message configuration";
    }

    public String test_message() {
        logger.info("++++++++test message configuration");
        return "test message configuration";
    }
}
