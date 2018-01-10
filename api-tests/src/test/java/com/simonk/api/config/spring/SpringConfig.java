package com.simonk.api.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.simonk.api.interactions.services.RestfulBookerService;

@Configuration
@PropertySource(value = { "classpath:/api-framework.properties" })
public class SpringConfig {


	@Bean
	public RestfulBookerService restfulBookerService() {
		return new RestfulBookerService();
	}
	
}
