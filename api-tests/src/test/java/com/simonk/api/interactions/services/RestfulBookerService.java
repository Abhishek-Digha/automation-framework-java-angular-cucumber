package com.simonk.api.interactions.services;

import com.simonk.api.interactions.dto.Booking;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestfulBookerService extends AbstractBaseService {

	private final String apiEndpoint = getBaseUrl() + "/booking/";
	private final RequestSpecification spec = new RequestSpecBuilder()
			.setContentType(ContentType.JSON).setBaseUri(getBaseUrl())
			.addFilter(new AllureRestAssured()).build();

	public RestfulBookerService(String base) {
		super(base);
	}

	@Step("Pinging service: Booking API")
	public boolean pingService() {
		return given().when().get(getBaseUrl() + "ping").getStatusCode() == 201;
	}

	@Step("Getting booking {id} with Accept type: {mediaType}.")
	public Response getBooking(int id, String mediaType) {
		return given().spec(spec).header("Accept", mediaType).get(
				apiEndpoint + Integer.toString(id));

	}

	@Step("Saving a new bookings")
	public Response postBooking(Booking payload) {
		return given().spec(spec).contentType(ContentType.JSON).body(payload).when()
				.post(apiEndpoint);
	}

	@Step("Deleting a booking: {id}")
	public Response deleteBooking(int id, String tokenValue) {
		return given().spec(spec).header("Cookie", "token=" + tokenValue).delete(
				apiEndpoint + Integer.toString(id));
	}

}
