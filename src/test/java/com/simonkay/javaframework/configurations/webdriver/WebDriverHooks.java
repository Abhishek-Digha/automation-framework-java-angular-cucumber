package com.simonkay.javaframework.configurations.webdriver;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.utility.reporting.ReportEnvironmentHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverHooks {
	private static boolean runOnce = true;
	private static final Logger LOG = LogManager.getLogger(WebDriverHooks.class);
	
	@Autowired
	private Driver driver;
	
	@Autowired
	private ReportEnvironmentHelper rh;

	//runs only on tagged hooks of this tag (warn level just to demo in report easy)
	@Before("@tagged-hooks-example")
	public void tagged_hooks_example() {
		LOG.warn("[BEFORE] This hook only runs on features tagged with @tagged-hook-example");
	}
	
	@Before
	public void log_scenario_started(Scenario scenario) {
		LOG.debug("[START OF SCENARIO] " + scenario.getId());
	}
	
	@Before
	public void delete_browser_cookies(Scenario scenario) {
		LOG.debug("deleting browser cookies");
		driver.manage().deleteAllCookies();
	}
	
	
	@After
	public void add_failure_attachments_if_needed(Scenario scenario) {
		LOG.debug("[END OF SCENARIO] " + scenario.getId());
		if (scenario.isFailed()) {
			LOG.fatal("[SCENARIO FAILED] Attaching page source and screenshot");
			check_if_pagesource(scenario);
			check_if_screenshot(scenario);
		}
	}
	
	//runs only on tagged hooks of this tag (warn just to show in report easy)
	@After("@tagged-hooks-example")
	public void tagged_hooks_after_example() {
		LOG.warn("[AFTER] This hook only runs after features tagged with @tagged-hook-example");
	}
	
	
	@Attachment(value = "failed_pagesource", type = "text/plain")
	public String  check_if_pagesource(Scenario scenario) {
		return driver.getPageSource().toString();
	}
	
	@Attachment(value = "failed_screenshot", type = "image/png")
	public byte[] check_if_screenshot(Scenario scenario) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	


}
