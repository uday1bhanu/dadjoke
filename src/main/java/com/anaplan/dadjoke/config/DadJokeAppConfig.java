package com.uday.dadjoke.config;

import com.uday.dadjoke.filter.ResponseHeadersFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadJokeAppConfig {

    @Bean
    public ResponseHeadersFilter responseHeadersFilter(){
        return new ResponseHeadersFilter();
    }

}