package com.ratingservice.services;

import java.util.List;

import com.ratingservice.entities.Rating;

public interface RatingService{

	//create
	Rating create(Rating r);
	
	//getall
	List<Rating> getAll();
	
	
	//getbyid
	Rating getById(int id);
	
	//updatebyid
	Rating updateById(Rating r,int id);
	
	//deletebyid
	Rating deleteById(int id);
	
	List<Rating> getByUserId(int userId);
	
	List<Rating> getHotelById(int hotelId);
	
}
