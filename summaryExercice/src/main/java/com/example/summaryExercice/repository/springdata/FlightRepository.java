package com.example.summaryExercice.repository.springdata;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.summaryExercice.domain.Flight;

@Transactional
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	@Query("Select count(f.id) from Flight f where f.departureDateAndTime = :departure and f.arrivalDateAndTime = :arrival")
	Integer existing(@Param("departure") Timestamp departureDateTime, @Param("arrival") LocalDateTime arrivalDateTime);

}
