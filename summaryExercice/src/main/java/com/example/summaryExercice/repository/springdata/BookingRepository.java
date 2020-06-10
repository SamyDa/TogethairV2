package com.example.summaryExercice.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.summaryExercice.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
