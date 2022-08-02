package com.yago.springcalculator.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class AppConfig {
    @Bean
    public static TracerImpl getTracer() {
        return new TracerImpl();
    }
}
  