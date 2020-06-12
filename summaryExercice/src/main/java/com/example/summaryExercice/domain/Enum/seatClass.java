package com.example.summaryExercice.domain.Enum;

public enum seatClass {
	
	Eco("eco") , FirstClass("first") , Business("business");
	
	private String name = "";



	seatClass(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return this.name;
	}
	
	
	
}
