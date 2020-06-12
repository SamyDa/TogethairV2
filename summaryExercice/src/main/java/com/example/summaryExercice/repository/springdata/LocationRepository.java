package com.example.summaryExercice.repository.springdata;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.summaryExercice.domain.Location;

@Transactional
public interface LocationRepository extends JpaRepository<Location,Integer> {

	Location findByAirportName(String airportName);

	Location findByAirportNameAndCountryName(String airportName, String countryName);
	@Query("Select Count(l.id) from Location l WHERE l.countryName = :#{#location.countryName} and l.airportName  = :#{#location.airportName}")
	Integer findLocation(@Param("location") Location location);

	List<Location> findByAirportCode(String airportCode);

	Location findOneByAirportCode(String airportCode);
	
}
	