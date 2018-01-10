package com.simonk.api.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

	@JsonProperty
	private int bookingid;
	@JsonProperty
	private Booking booking;

	public int getBookingid() {
		return bookingid;
	}

	public Booking getBooking() {
		return booking;
	}

}
