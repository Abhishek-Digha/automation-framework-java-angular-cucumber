package com.simonk.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ServiceProperties {	
	
    @Autowired
    private Environment environment;
    
    public String getBaseEndpoint() {
        return environment.getProperty("environment.endpoint");
    }
    
    
}
