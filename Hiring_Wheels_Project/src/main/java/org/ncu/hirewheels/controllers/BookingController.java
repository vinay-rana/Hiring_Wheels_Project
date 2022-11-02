package org.ncu.hirewheels.controllers;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/hirewheels/v1/addbooking",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> addVehicle(@RequestBody Booking booking){
		Booking bookingDetails = bookingService.addBooking(booking);
		if(bookingDetails == null) {
			return new ResponseEntity<>(bookingService.addBooking(booking),HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			return new ResponseEntity<>(bookingService.addBooking(booking),HttpStatus.CREATED);
		}
	}
}
