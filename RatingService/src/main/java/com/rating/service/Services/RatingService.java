package com.rating.service.Services;

import java.util.List;

import com.rating.service.Entities.Rating;

public interface RatingService {

	
	//create
	Rating create(Rating rate);
	
	//get All
	List<Rating> getAllRatigs();
	
	//get All by UserID
	List<Rating> getRatingByUserId(String userid);
	
	//get all by hotelId
	List<Rating> getRatingByHotelId(String hotelid);
}
