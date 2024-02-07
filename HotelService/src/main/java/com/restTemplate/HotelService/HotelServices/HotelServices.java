package com.restTemplate.HotelService.HotelServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restTemplate.HotelService.entities.Hotel;
@Service
public interface HotelServices {
	
	//create
	Hotel create(Hotel h);
	
	//getAll
	List<Hotel> getAllHotels();
	
	//getHotelById
	Hotel getHotelById(int id);
	
	//update
	Hotel updateHotel(Hotel h,int id);
	
	//delete hotel by id
	Hotel deleteHotelById(int id);

	
}
