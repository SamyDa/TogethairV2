package com.example.summaryExercice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.summaryExercice.domain.Booking;
import com.example.summaryExercice.domain.Customer;
import com.example.summaryExercice.domain.User;
import com.example.summaryExercice.repository.springdata.BookingRepository;
import com.example.summaryExercice.repository.springdata.FlightRepository;
import com.example.summaryExercice.repository.springdata.UserRepository;

@Service
public class BookingService {

	private UserService userService;
	private FlightService flightService;
	
	public BookingService(UserService userService , FlightService flightService) {
		this.userService = userService;
		this.flightService = flightService;
	}
	
	public void test() {
		System.out.println("service ==> " + userService);
	}
	
	public void save(int customerId, Booking booking) {
		
		System.out.println("Service user ==> "+ userService);
		System.out.println("Service flight ==> "+ flightService);
		
		Optional<User> optionalUser =  userService.findById(customerId);
		System.out.println("");
		
	
		try {
			Customer customer = (Customer) userService.findById(customerId).get();
			
			if (flightService.findById(booking.getFlight().getId()).isPresent()){
				booking.setFlight(flightService.findById(booking.getFlight().getId()).get());
				customer.addBooking(booking);
			}
			userService.save(customer);
		}
		catch(NullPointerException e) {
			System.out.println("customer not found");
		}
		catch(ClassCastException e) {
			System.out.println("User retrieved is not a Customer (Id) ");
		}
		
	}
	
	
	
	
}
