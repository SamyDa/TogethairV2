package com.example.summaryExercice;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummaryExerciceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummaryExerciceApplication.class, args);
		System.out.println("Test push");
		System.out.println("LocalDate.now() = " + LocalDateTime.now());
		System.out.println("Timestamp(LocalDate.now()) = " + Timestamp.valueOf( LocalDateTime.now()));
	}

}
