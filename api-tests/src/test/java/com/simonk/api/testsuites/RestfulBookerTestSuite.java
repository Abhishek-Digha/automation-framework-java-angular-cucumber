package com.simonk.api.testsuites;

import io.restassured.response.Response;

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
public class RestfulBookerTestSuite extends AbstractServiceTestSuite {

	@Autowired
	public RestfulBookerService restfulBookerService;
	
	@Test
	public void getBookingIdShouldReturn200() {
		Response response = restfulBookerService.getBooking(1, "application/json");
		assertThat(response.getStatusCode()).as("Checking status code is 200").isEqualTo(200);
	}
	
}
