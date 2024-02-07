package com.ratingservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratingservice.entities.Rating;
import com.ratingservice.exceptions.ResourceNotFoundException;
import com.ratingservice.repositories.RatingRepository;
import com.ratingservice.services.RatingService;
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository repository;
		
	@Override
	public Rating create(Rating r) {
		// TODO Auto-generated method stub
		return repository.save(r);
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Rating getById(int ratingId) {
		// TODO Auto-generated method stub
		Rating rating = repository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Id not found in database to fetch"));
		return rating;
	}

	@Override
	public Rating updateById(Rating r, int id) {
		// TODO Auto-generated method stub
		Rating rating = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found in database"));
		rating.setUserId(r.getUserId());
		rating.setRatingId(r.getRatingId());
		rating.setFeedback(r.getFeedback());
		rating.setHotelId(r.getHotelId());
		rating.setRating(r.getRating());
		repository.save(r);
		return rating;
	}

	@Override
	public Rating deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Rating> optional = repository.findById(id);
		if(optional.isPresent()) {
			Rating rating = optional.get();
			repository.deleteById(id);
			return rating;
		}
		else {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public List<Rating> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getHotelById(int hotelId) {
		// TODO Auto-generated method stub
		return repository.findByHotelId(hotelId);
	}

	

}
