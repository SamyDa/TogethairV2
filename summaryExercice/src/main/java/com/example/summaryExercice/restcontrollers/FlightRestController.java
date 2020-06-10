package com.example.summaryExercice.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.summaryExercice.domain.Flight;
import com.example.summaryExercice.service.FlightService;

@RestController
public class FlightRestController {
	
	private FlightService flightService;

	public FlightRestController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}
	
	
	@GetMapping(path = "/flights")
	public List<Flight> findAllFlights(){
		
		return flightService.findAll();
		
	}
	
	@PostMapping(path = "/flights/add")
	public void setFlight(@RequestBody Flight flight, @RequestParam(name = "Test") String paramValue) {
		
		System.out.println(flight.toString());
		System.out.println("The param value is " + paramValue);
		flightService.save(flight);
		System.out.println("Test");
		System.out.println(flight.getDeparture());
		System.out.println("TO string !");
		System.out.println(flight.getDeparture().toString());
		flightService.test(flight.getDeparture(), flight);
	}

	
}
