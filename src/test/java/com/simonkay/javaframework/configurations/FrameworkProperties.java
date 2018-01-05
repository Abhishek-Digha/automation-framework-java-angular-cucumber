package com.simonkay.javaframework.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class FrameworkProperties {
	private static final Logger LOG = LogManager.getLogger(FrameworkProperties.class);

    @Autowired
    private Environment environment;
   
    
    public String getTestServerBaseAddress() {
    	String result = environment.getProperty("env.baseurl");
    	return result;
    }
    
    public String getGridAddress() {
    	return environment.getProperty("grid.endpoint");  	
    }
    
    public String getGridOrLocal() {
    	return environment.getProperty("run.on.browserstack.grid.local");

    }
    
    public String getBrowserType() {
    	return environment.getProperty("browser");
    }
    
    public String getPlatformType() {
    	return environment.getProperty("platform");

    }
    
    public int seleniumImplicitWaitTime() {
    	return environment.getProperty("driver.implicit.wait", Integer.class);

    }
    
    public String getApplicationLanguage() {
    	return environment.getProperty("application.language");
    }
    
    public String getProductName() {
    	return environment.getProperty("product.name");
    }
    
    public String getDatabaseConn() {
    	return environment.getProperty("database.connection");
    }
    
    public String getAngular() {
    	return environment.getProperty("is.frontend.angular");
    }


    
    
}
