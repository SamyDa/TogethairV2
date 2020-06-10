package com.example.summaryExercice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.summaryExercice.domain.Flight;
import com.example.summaryExercice.domain.Location;
import com.example.summaryExercice.repository.springdata.FlightRepository;

@Service
public class FlightService {
	
	private FlightRepository flightRepository;
	private LocationService locationService;
	

	public FlightService(FlightRepository flightRepository, LocationService locationService) {
		super();
		this.flightRepository = flightRepository;
		this.locationService = locationService;
	}
	public void save(Flight flight) {
		/*//check if location is existing : 
		Location location = locationService.getExisting(flight.getArrival());
		if( location != null) {
			System.out.println("Arrival already existing");
			flight.setArrival(location);
		}
		 location = locationService.getExisting(flight.getDeparture());
		if( location != null) {
			System.out.println("Departure already existing");
			flight.setDeparture(location);
		}*/
		System.out.println("saving flight");
		System.out.println("with flight arrival = " + flight.getArrivalDateAndTime());
		System.out.println("with flight departure = " + flight.getDepartureDateAndTime());
		flightRepository.save(flight);
	}
	public void delete(Flight flight) {
		flightRepository.delete(flight);
	}
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}
	public Optional<Flight> findById(int id) {
		return flightRepository.findById(id);
	}
	public void test(Location location, Flight flight) {
	//	locationService.getExisting(location);
	//	System.out.println("Parameters = " + flight.getDepartureDateAndTime() + " && " + flight.getArrivalDateAndTime());
	//	System.out.println("Test existing ==> " + flightRepository.existing(flight.getDepartureDateAndTime(), flight.getArrivalDateAndTime()));
	}
	

}
