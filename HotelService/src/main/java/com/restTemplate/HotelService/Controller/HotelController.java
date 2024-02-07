package com.restTemplate.HotelService.Controller;

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

import com.restTemplate.HotelService.HotelServices.HotelServices;
import com.restTemplate.HotelService.entities.Hotel;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelServices services;
	
	@PostMapping("/create")
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(services.create(hotel),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return new ResponseEntity<List<Hotel>>(services.getAllHotels(),HttpStatus.OK);
	}
	
	@GetMapping("/getHotelById/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") int id){
		return new ResponseEntity<Hotel>(services.getHotelById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotelById(@RequestBody Hotel h,@PathVariable("id") int id){
		return new ResponseEntity<Hotel>(services.updateHotel(h, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Hotel> deleteHotelById(@PathVariable("id") int id){
		return new ResponseEntity<Hotel>(services.deleteHotelById(id),HttpStatus.OK);
	}
	
	
	

}
