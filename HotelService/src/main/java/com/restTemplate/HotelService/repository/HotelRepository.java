package com.restTemplate.HotelService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restTemplate.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	
}
