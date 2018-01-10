package com.simonk.api.interactions.services;

import com.simonk.api.interactions.dto.Booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class RestfulBookerService extends AbstractBaseService {

	private final String apiEndpoint = getBaseUrl() + "/booking";

	public RestfulBookerService(String base) {
		super(base);
	}

	
	public boolean pingService() {
		return given().when().get(getBaseUrl() + "ping").getStatusCode() == 201;		
	}

	public Response getBooking(int id, String mediaType) {
		return given().header("Accept", mediaType).get(
				apiEndpoint + Integer.toString(id));
	}

	public Response postBooking(Booking payload) {
		return given().contentType(ContentType.JSON).body(payload).when()
				.post(apiEndpoint);
	}

	public Response deleteBooking(int id, String tokenValue) {
		return given().header("Cookie", "token=" + tokenValue).delete(
				apiEndpoint + Integer.toString(id));
	}

}
