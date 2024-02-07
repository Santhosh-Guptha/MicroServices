package com.restTemplate.HotelService.HotelServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restTemplate.HotelService.Exceptions.HotelNotFound;
import com.restTemplate.HotelService.HotelServices.HotelServices;
import com.restTemplate.HotelService.entities.Hotel;
import com.restTemplate.HotelService.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelServices{
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel h) {
		// TODO Auto-generated method stub
		return hotelRepository.save(h);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> hotel = hotelRepository.findById(id);
		Hotel hotel2 = hotel.orElseThrow(()->new HotelNotFound("Hotel Not found by the given id to get"));
		return hotel2;
	}

	@Override
	public Hotel updateHotel(Hotel h, int id) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new HotelNotFound("Hotrel not found by the given id to update"));
		hotel.setId(h.getId());
		hotel.setName(h.getName());
		hotel.setLocation(h.getLocation());
		hotelRepository.save(hotel);
		return hotel;
	}

	@Override
	public Hotel deleteHotelById(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> optional = hotelRepository.findById(id);
		if(optional.isPresent()) {
			Hotel hotel = optional.get();
			hotelRepository.deleteById(id);
			return hotel;
		}
		else {
			throw new HotelNotFound("Hotel noyt find by the given id....");
		}
	}

	
	

}
