package com.example.summaryExercice.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.summaryExercice.domain.Flight;
import com.example.summaryExercice.domain.Pricing;
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
		
		flightService.save(flight);
	}
	@PostMapping(path = "/flights/addList")
	public void setFlightList(@RequestBody List<Flight> flight) {
		System.out.println("Saving list");
		flightService.saveList(flight);
	}
	
	@PostMapping(path = "/flights/{id}/addPrice")
	public void setPrice(@RequestBody Pricing price, @PathVariable("id") long id ) {
		flightService.setPrice(id, price);
		
	}

	
}
