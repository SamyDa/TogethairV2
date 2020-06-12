package com.example.summaryExercice.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Pricing {

	@Id
	@GeneratedValue
	private long id;
	
	private double basePriceEco;
	private double basePriceFirst;
	private double basePriceBus;
	private double customToghetairPrice;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "seattreshold_fk")
	@Cascade( CascadeType.ALL)
	private List<SeatTreshold> seatTreshold;
	
	
	
	
	public Pricing() {
		super();
	}
	
	public Pricing(double basePriceEco, double basePriceFirst, double basePriceBus, double volumeDiscountPerc,
			double customToghetairPrice, List<SeatTreshold> seatTreshold) {
		super();
		this.basePriceEco = basePriceEco;
		this.basePriceFirst = basePriceFirst;
		this.basePriceBus = basePriceBus;
		this.customToghetairPrice = customToghetairPrice;
		this.seatTreshold = seatTreshold;
	}
	
	public double calculateTotalPrice() {
		double total = 0;
		return total; 
	}
	
	
	public double getBasePriceEco() {
		return basePriceEco;
	}
	public void setBasePriceEco(double basePriceEco) {
		this.basePriceEco = basePriceEco;
	}
	public double getBasePriceFirst() {
		return basePriceFirst;
	}
	public void setBasePriceFirst(double basePriceFirst) {
		this.basePriceFirst = basePriceFirst;
	}
	public double getBasePriceBus() {
		return basePriceBus;
	}
	public void setBasePriceBus(double basePriceBus) {
		this.basePriceBus = basePriceBus;
	}
	public double getCustomToghetairPrice() {
		return customToghetairPrice;
	}
	public void setCustomToghetairPrice(double customToghetairPrice) {
		this.customToghetairPrice = customToghetairPrice;
	}
	public List<SeatTreshold> getSeatTreshold() {
		return seatTreshold;
	}
	public void setSeatTreshold(List<SeatTreshold> seatTreshold) {
		this.seatTreshold = seatTreshold;
	}
	
	public void addSeatTreshold(SeatTreshold seatTreshold) {
		
		for(SeatTreshold st : this.seatTreshold ) {
			if (st.getSeat() == seatTreshold.getSeat()) {
				
				st.setDiscount(seatTreshold.getDiscount());
				return;
			}
			
		}
		this.seatTreshold.add(seatTreshold);
	}
	
	
}
