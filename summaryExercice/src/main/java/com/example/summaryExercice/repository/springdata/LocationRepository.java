package com.example.summaryExercice.repository.springdata;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.summaryExercice.domain.Location;

@Transactional
public interface LocationRepository extends JpaRepository<Location,Integer> {

	Location findByAirportName(String airportName);

	Location findByAirportNameAndCountryName(String airportName, String countryName);
	
}
