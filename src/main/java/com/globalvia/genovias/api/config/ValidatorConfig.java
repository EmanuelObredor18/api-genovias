package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.validator.base.Validator;

@Configuration
public class ValidatorConfig {
  
  @Bean
  Validator validator() {
    return new Validator();
  }

}
