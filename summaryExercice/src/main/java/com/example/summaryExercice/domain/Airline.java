package com.example.summaryExercice.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("A")
public class Airline extends User {
	
	private String airlineName; 
	private String airlineAcronym;
	@OneToMany
	List<Flight> flights;
	
	
	public Airline() {
		super();
	}
	public Airline(String airlineName, String airlineAcronym, List<Flight> flights) {
		super();
		this.airlineName = airlineName;
		this.airlineAcronym = airlineAcronym;
		this.flights = flights;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAirlineAcronym() {
		return airlineAcronym;
	}
	public void setAirlineAcronym(String airlineAcronym) {
		this.airlineAcronym = airlineAcronym;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	

}
