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

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Location departure;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Location arrival;
	private Timestamp departureDateAndTime;
	private LocalDateTime arrivalDateAndTime;
	private int nrOfpassenger;
	
	
	
	public Flight() {
		super();
	}
	public Flight(Location departure, Location arrival, Timestamp departureDateAndTime, LocalDateTime arrivalDateAndTime,
			int nrOfpassenger, List<Booking> booking) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.departureDateAndTime = departureDateAndTime;
		this.arrivalDateAndTime = arrivalDateAndTime;
		this.nrOfpassenger = nrOfpassenger;
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
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDateAndTime="
				+ departureDateAndTime + ", arrivalDateAndTime=" + arrivalDateAndTime + ", nrOfpassenger="
				+ nrOfpassenger + "]";
	}
	
	
}
