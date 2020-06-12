package com.example.summaryExercice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("C")
public class Customer extends User {
	private String firstName ;
	private String lastName;
	private String email;
	@OneToOne(fetch = FetchType.EAGER)
	private BillingInformation billingInformation;
	private String mobileNumber; 
	@OneToMany(targetEntity=Booking.class,  fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_fk")
	private List<Booking> bookings;
	public Customer(String firstName, String lastName, String email, BillingInformation billingInformation,
			String mobileNumber, List<Booking> bookings) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.billingInformation = billingInformation;
		this.mobileNumber = mobileNumber;
		this.bookings = bookings;
	}
	
	
	public Customer() {
		super();
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BillingInformation getBillingInformation() {
		return billingInformation;
	}
	public void setBillingInformation(BillingInformation billingInformation) {
		this.billingInformation = billingInformation;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
		
	} 
	
	
	
	
	

}
