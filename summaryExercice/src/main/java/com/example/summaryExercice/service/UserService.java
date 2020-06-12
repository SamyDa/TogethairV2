package com.example.summaryExercice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.summaryExercice.domain.Airline;
import com.example.summaryExercice.domain.User;
import com.example.summaryExercice.repository.springdata.UserRepository;

@Service
public class UserService {
	
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public int save(User user) {
		System.out.println("Saving process");
		userRepository.save(user);
		System.out.println("user saved ");
		return user.getId();
	}
	public void delete(User user) {
		userRepository.delete(user);
	}
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public List<User> findByDisc(char discriminator) {
		return userRepository.findAllAirline();
	}
	
	
	
}
