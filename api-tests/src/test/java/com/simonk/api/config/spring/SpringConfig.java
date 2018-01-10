package com.simonk.api.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simonk.api.config.ServiceProperties;
import com.simonk.api.interactions.dto.Test2;
import com.simonk.api.interactions.services.AuthentificationService;
import com.simonk.api.interactions.services.RestfulBookerService;

@Configuration
@PropertySource(value = { "classpath:/api-framework.properties" })
public class SpringConfig {
	private static final Logger LOG = LogManager.getLogger(SpringConfig.class);

	@Bean
	public ServiceProperties properties() {
		return new ServiceProperties();
	}

	@Bean
	public RestfulBookerService restfulBookerService() {
		return new RestfulBookerService(properties().getBaseEndpoint());
	}
	
	@Bean
	public AuthentificationService authService() {
		return new AuthentificationService(properties().getBaseEndpoint());
	}
	
	
}
