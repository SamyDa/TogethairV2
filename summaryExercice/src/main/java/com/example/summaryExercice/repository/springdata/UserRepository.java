package com.example.summaryExercice.repository.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.summaryExercice.domain.Airline;
import com.example.summaryExercice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where Type(u) = Airline")
	List<User> findAllAirline();

}
