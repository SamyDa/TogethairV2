package com.example.summaryExercice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

	@Id 
	@GeneratedValue
	int id;
	String airportName;
	String countryName;
	String airportCode;
	String globalRegion;
	
	public Location() {
		super();
	}

	public Location(String airportName, String countryName, String airportCode, String globalRegion) {
		super();
		this.airportName = airportName;
		this.countryName = countryName;
		this.airportCode = airportCode;
		this.globalRegion = globalRegion;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getGlobalRegion() {
		return globalRegion;
	}

	public void setGlobalRegion(String globalRegion) {
		this.globalRegion = globalRegion;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", airportName=" + airportName + ", countryName=" + countryName + ", airportCode="
				+ airportCode + ", globalRegion=" + globalRegion + "]";
	}

	
	
}
