package com.example.summaryExercice.service;

import java.util.List;
import java.util.Optional;

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

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void save(Location location) {
		//first check if the location already exists
		System.out.println("Saving Location : " + location.toString());
		if (!existingLocation(location)) {
			locationRepository.save(location);
		}
		
	}

	private boolean existingLocation(Location location) {
		System.out.println("Existing Location");
		int count = locationRepository.findLocation(location);
		if (count > 0)
			System.out.println("Location already exists !!");
		else 
			System.out.println("Location is free and will be saved");
		return false;
	}

	public void saveList(List<Location> location) {
		location.forEach(n -> { save(n);});
		
	}

	public boolean existing(Location location) {
		if(location != null )
		{
			return(locationRepository.findByAirportCode(location.getAirportCode()).size() > 0 );
		}
		return false;
	}

	public Location findByAirportCode(String airportCode) {
		return locationRepository.findOneByAirportCode(airportCode);
	}


	
	
	
}
