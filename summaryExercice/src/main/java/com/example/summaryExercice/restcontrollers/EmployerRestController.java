package com.example.summaryExercice.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.summaryExercice.domain.Airline;
import com.example.summaryExercice.domain.Location;
import com.example.summaryExercice.domain.User;
import com.example.summaryExercice.service.LocationService;
import com.example.summaryExercice.service.UserService;

import javassist.NotFoundException;

@RestController
public class EmployerRestController {
	
	
	private LocationService locationService;
	private UserService userService;
	
	
	
	
	public EmployerRestController(LocationService locationService, UserService userService) {
		super();
		this.locationService = locationService;
		this.userService = userService;
	}
	
	
	@GetMapping(path = "employees/location")
	public List<Location> findAllLocation(){
		List<Location> locations = locationService.findAll();
		
		if(locations == null)
			return new ArrayList<Location>();
		else
			return locations; 
		
	}
	@GetMapping(path = "employees/airline")
	public List<User> findAllAirlines(){
		return userService.findByDisc('A');
		
	}
	@GetMapping(path = "employees/location/{id}")
	public Optional<Location> findLocationById(@PathVariable("id") int id ) throws NotFoundException{
		
		return locationService.findById(id);
		
	}
	
	@PostMapping(path = "employees/location/add")
	public void setLocation(@RequestBody Location location) {
		locationService.save(location);
	}
	@PostMapping(path = "employees/location/addList")
	public void setLocation(@RequestBody List<Location> location) {
		locationService.saveList(location);
	}

}
