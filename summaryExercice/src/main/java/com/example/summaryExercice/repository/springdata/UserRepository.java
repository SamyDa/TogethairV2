package com.example.summaryExercice.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.summaryExercice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//@Query("set the query here if needed")
}
