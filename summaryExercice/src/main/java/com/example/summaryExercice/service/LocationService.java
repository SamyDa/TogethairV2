package com.example.summaryExercice.service;

import org.springframework.stereotype.Service;

import com.example.summaryExercice.domain.Location;
import com.example.summaryExercice.repository.springdata.LocationRepository;

@Service
public class LocationService {

	
	private LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}
	
	public Location getExisting(Location location) {
		System.out.println("Find By name : "  + locationRepository.findByAirportName( location.getAirportName()).toString());
		System.out.println("Find By name  & countryName: "  + locationRepository.findByAirportNameAndCountryName( location.getAirportName(), location.getCountryName()).toString());
		return locationRepository.findByAirportNameAndCountryName( location.getAirportName(), location.getCountryName());
		//return locationRepository.exists(location);
	}
	
	
	
}
