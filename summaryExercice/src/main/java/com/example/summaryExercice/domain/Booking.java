package com.example.summaryExercice.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;
	private double price;
	private int nrTickets;
	private boolean paymentStatus;
	
	
	public Booking(Flight flight, double price, int nrTickets, Customer customer, boolean paymentStatus) {
		super();
	//	this.flight = flight;
		this.price = price;
		this.nrTickets = nrTickets;
		this.paymentStatus = paymentStatus;
	}
	
//	public Flight getFlight() {
//		return flight;
//	}
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNrTickets() {
		return nrTickets;
	}
	public void setNrTickets(int nrTickets) {
		this.nrTickets = nrTickets;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
	
}
