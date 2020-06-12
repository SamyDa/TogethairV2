package com.example.summaryExercice.domain;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Location departure;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Location arrival;
	private Timestamp departureDateAndTime;
	private LocalDateTime arrivalDateAndTime;
	private int nrOfpassenger;
	private String airline;
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	private Pricing price;
	
	
	
	public Flight() {
		super();
		price  = new Pricing();
	}
	public Flight(Location departure, Location arrival, Timestamp departureDateAndTime, LocalDateTime arrivalDateAndTime,
			int nrOfpassenger, List<Booking> booking) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.departureDateAndTime = departureDateAndTime;
		this.arrivalDateAndTime = arrivalDateAndTime;
		this.nrOfpassenger = nrOfpassenger;
		this.price  = new Pricing();
	}
	
	
	public int getId() {
		return id;
	}
	public Location getDeparture() {
		return departure;
	}
	public void setDeparture(Location departure) {
		this.departure = departure;
	}
	public Location getArrival() {
		return arrival;
	}
	public void setArrival(Location arrival) {
		this.arrival = arrival;
	}
	public Timestamp getDepartureDateAndTime() {
		return departureDateAndTime;
	}
	public void setDepartureDateAndTime(Timestamp departureDateAndTime) {
		this.departureDateAndTime = departureDateAndTime;
	}
	public LocalDateTime getArrivalDateAndTime() {
		return arrivalDateAndTime;
	}
	public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
		this.arrivalDateAndTime = arrivalDateAndTime;
	}
	public int getNrOfpassenger() {
		return nrOfpassenger;
	}
	public void setNrOfpassenger(int nrOfpassenger) {
		this.nrOfpassenger = nrOfpassenger;
	}
	
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public Pricing getPrice() {
		return price;
	}
	public void setPrice(Pricing price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDateAndTime="
				+ departureDateAndTime + ", arrivalDateAndTime=" + arrivalDateAndTime + ", nrOfpassenger="
				+ nrOfpassenger + "]";
	}
	
	
}
