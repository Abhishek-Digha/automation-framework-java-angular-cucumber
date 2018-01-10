package com.simonk.api.testsuites;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

import com.simonk.api.config.spring.SpringConfig;
import com.simonk.api.interactions.services.RestfulBookerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class RestfulBookerTest extends AbstractServiceTestSuite {

	@Autowired
	public RestfulBookerService restfulBookerService;
		
	@Test
	@DisplayName("Get booking by id returns 200 ok")
	@Issue("001")
	@TmsLink("001")
	@Severity(SeverityLevel.CRITICAL)
	public void getBookingIdShouldReturn200() {
		Response response = restfulBookerService.getBooking(1);
		assertThat(response.getStatusCode()).as("Checking status code is 200").isEqualTo(200);
	}
	
	@Test
	@DisplayName("Get a booking returns a 200 ok")
	@Issue("001")
	@TmsLink("001")
	@Severity(SeverityLevel.CRITICAL)
	public void getBookingsShouldReturn200() {
		Response response = restfulBookerService.getBookings();
		assertThat(response.getStatusCode()).as("Get all bookings returns 200").isEqualTo(200);
	}
	
	@Test
	@DisplayName("Pinging the service returns 201 Created")
	@Issue("003")
	@TmsLink("003")
	@Severity(SeverityLevel.CRITICAL)
	public void pingBookingsShouldReturn201() {
		Response response = restfulBookerService.pingService();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(response.getStatusCode()).as("Ping should return 201").isEqualTo(201);
		softly.assertThat(response.getStatusLine()).as("Ping returns Created").contains("Created");
		softly.assertAll();
	}
	
	@Test
	@DisplayName("Pinging the service returns 201 Created")
	@Issue("004")
	@TmsLink("004")
	@Severity(SeverityLevel.CRITICAL)
	public void getBookingWithNonExistingIdShouldReturn404() {
		Response response = restfulBookerService.getBooking(252525);
		assertThat(response.getStatusCode()).as("Non existing booking id returns 404").isEqualTo(404);
	}
	
}
