package com.rating.service.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.service.Entities.Rating;

public interface RatingRepository extends MongoRepository<Rating , String>{

	//creating custom finder methods by following naming convention
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
