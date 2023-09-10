package com.rating.service.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.Entities.Rating;
import com.rating.service.Repositories.RatingRepository;
import com.rating.service.Services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rate) {
		
		return ratingRepository.save(rate);
	}

	@Override
	public List<Rating> getAllRatigs() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userid) {
		return ratingRepository.findByUserId(userid);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelid) {
		return ratingRepository.findByHotelId(hotelid);
	}

}
