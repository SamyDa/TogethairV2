package com.example.summaryExercice.restcontrollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.summaryExercice.domain.Booking;
import com.example.summaryExercice.domain.Customer;
import com.example.summaryExercice.service.BookingService;
import com.example.summaryExercice.service.UserService;

@RestController
public class TicketRestController {
	
	private UserService userService;
	private BookingService bookingService;
	
	
	
	public TicketRestController(UserService userService, BookingService bookingService) {
		super();
		this.userService = userService;
		this.bookingService = bookingService;
	}
	


	@PostMapping(path = "/customer/register")
	public int registerCustomer(@RequestBody Customer customer) {
		System.out.println("Test register : user service = " + userService);
		return userService.save(customer);
		
		
	}
	
	@PostMapping("/customer/{id}/book")
	public void registerBooking(@RequestBody Booking booking , @PathVariable("id") int customerId) {
		System.out.println("\n To string : "+booking.toString()+"\n --------------\n");
		System.out.println("\n To string : "+booking.getFlight().toString()+"\n --------------\n");
		System.out.println("\n To string : "+booking.getFlight().getId()+"\n --------------\n");
    	bookingService.save(customerId, booking);
		bookingService.test();
		
	}

}
