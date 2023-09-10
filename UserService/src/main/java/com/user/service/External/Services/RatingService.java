package com.user.service.External.Services;

import org.springframework.cloud.openfeign.FeignClient;

import com.user.service.Entities.Rating;

@FeignClient(name= "RATINGSERVICE")
public interface RatingService {

	//get
	
	//post
	public Rating createRating();
	
	//put
}
