package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entities.Rating;
import com.ratingservice.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService service;
	
	@PostMapping("/save")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(service.create(rating),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Rating> updateById(@RequestBody Rating rating,@PathVariable("id") int id){
		return new ResponseEntity<Rating>(service.updateById(rating, id),HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Rating>> getAllRatings(){
		return new ResponseEntity<List<Rating>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Rating> updateById(@PathVariable("id") int id){
		return new ResponseEntity<Rating>(service.getById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Rating> deleteById(@PathVariable int id){
		return new ResponseEntity<Rating>(service.deleteById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getByUserId/{id}")
	public ResponseEntity<List<Rating>> getByUser(@PathVariable("id") int userId){
		return new ResponseEntity<List<Rating>>(service.getByUserId(userId),HttpStatus.OK);
	}

	@GetMapping("/getByHotelId/{id}")
	public ResponseEntity<List<Rating>> getHotel(@PathVariable("id") int hotelId){
		return new ResponseEntity<List<Rating>>(service.getHotelById(hotelId),HttpStatus.OK);
	}
}
