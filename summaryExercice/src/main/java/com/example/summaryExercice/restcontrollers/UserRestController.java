package com.example.summaryExercice.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.summaryExercice.domain.Airline;
import com.example.summaryExercice.domain.User;
import com.example.summaryExercice.service.UserService;

@RestController
public class UserRestController {

	private UserService userService;

	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping(path = "/users")
	public List<User> findAllUser(){
		return userService.findAll();
	}
	
	@PostMapping(path = "/addusers")
	public void saveUser() {
		
		//userService.save(new Airline());
	}
}
