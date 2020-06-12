package com.example.summaryExercice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeatTreshold {
	@Id
	@GeneratedValue
	private long id;
	private int seat;
	private double discount;
	
	
	public SeatTreshold() {
		super();
	}
	public SeatTreshold(int seat, double discount) {
		super();
		this.seat = seat;
		this.discount = discount;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
}
