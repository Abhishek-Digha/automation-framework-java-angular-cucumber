package com.simonk.api.interactions.services;

import com.simonk.api.interactions.dto.Booking;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestfulBookerService extends AbstractBaseService {

	private final String apiEndpoint = getBaseUrl() + "booking/";
	

	public RestfulBookerService(String base) {
		super(base);
	}

	@Step("Pinging service: Booking API")
	public Response pingService() {
		return given().when().get(getBaseUrl() + "ping");
	}
	
	@Step("Retrieve a list of all bookings")
	public Response getBookings() {
		return given().spec(getSpec()).get(apiEndpoint);
	}

	@Step("Getting booking {id}")
	public Response getBooking(int id) {
		return given().spec(getSpec()).get(
				apiEndpoint + Integer.toString(id));

	}

	@Step("Saving a new bookings")
	public Response postBooking(Booking payload) {
		return given().spec(getSpec()).body(payload).when()
				.post(apiEndpoint);
	}

	@Step("Deleting a booking: {id}")
	public Response deleteBooking(int id, String tokenValue) {
		return given().spec(getSpec()).header("Cookie", "token=" + tokenValue).delete(
				apiEndpoint + Integer.toString(id));
	}

}
