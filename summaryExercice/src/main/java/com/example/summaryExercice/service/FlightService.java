package com.example.summaryExercice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.summaryExercice.domain.Flight;
import com.example.summaryExercice.domain.Location;
import com.example.summaryExercice.domain.Pricing;
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
		if( locationService.existing(flight.getArrival()) && locationService.existing(flight.getDeparture()) ) {
			flight.setArrival(locationService.findByAirportCode(flight.getArrival().getAirportCode()));
			flight.setDeparture(locationService.findByAirportCode(flight.getDeparture().getAirportCode()));
			flightRepository.save(flight);
		}
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

	public void saveList(List<Flight> flight) {
		flight.forEach(n -> save(n));
	}
	public void setPrice(long flightId, Pricing price) {
		System.out.println("Set prrice entering");
		Optional<Flight> flight = flightRepository.findById((int)flightId);
		System.out.println("Found flight is " + flight.toString());
		if(flight.isPresent())
		{
			//If the price has not been set yet
			if(flight.get().getPrice() == null)
				flight.get().setPrice(price);
			else {
				//if the price has already been set, check if the change comes from the airline or the togethair employee. To check it, we evaluate the base price
				if(price.getBasePriceBus() != 0 ) {
					System.out.println("Entering the not null part ");
					flight.get().getPrice().setBasePriceEco(price.getBasePriceEco());
					flight.get().getPrice().setBasePriceFirst(price.getBasePriceFirst());
					flight.get().getPrice().setBasePriceBus(price.getBasePriceBus());
					System.out.println("Prices are set ");
					System.out.println("price.getSeatTreshold() ==> "+ price.getSeatTreshold());
					System.out.println("flight.get().getPrice().getSeatTreshold() ==> " + flight.get().getPrice().getSeatTreshold());
					price.getSeatTreshold().forEach(n -> {flight.get().getPrice().addSeatTreshold(n);});
					
				}
				else {
					flight.get().getPrice().setCustomToghetairPrice(price.getCustomToghetairPrice());					
				}
			}
			flightRepository.save(flight.get());
		}
		else {
			System.out.println("Set Price - Flight not found");
		}
		
	}
	

}
