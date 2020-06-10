package com.example.summaryExercice.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class BillingInformation {

	@Id
	@GeneratedValue
	private long id;
	private String nameOnCard;
	private long creditCardNumber ;
	private LocalDate creditCardExpryDate;
	private int creditCardCvvNumber; 
	@OneToOne(fetch = FetchType.EAGER)
	private Address billingAddress;
	
	
	public BillingInformation(String nameOnCard, long creditCardNumber, LocalDate creditCardExpryDate,
			int creditCardCvvNumber, Address billingAddress) {
		super();
		this.nameOnCard = nameOnCard;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpryDate = creditCardExpryDate;
		this.creditCardCvvNumber = creditCardCvvNumber;
		this.billingAddress = billingAddress;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public LocalDate getCreditCardExpryDate() {
		return creditCardExpryDate;
	}
	public void setCreditCardExpryDate(LocalDate creditCardExpryDate) {
		this.creditCardExpryDate = creditCardExpryDate;
	}
	public int getCreditCardCvvNumber() {
		return creditCardCvvNumber;
	}
	public void setCreditCardCvvNumber(int creditCardCvvNumber) {
		this.creditCardCvvNumber = creditCardCvvNumber;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
	
	
}
