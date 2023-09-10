package com.user.service.Services.Impl;

import java.util.Arrays;
import java.util.List; 
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.Entities.Hotel;
import com.user.service.Entities.Rating;
import com.user.service.Entities.User;
import com.user.service.Exceptions.ResourceNotFoundException;
import com.user.service.External.Services.HotelService;
import com.user.service.Repositories.UserRepository;
import com.user.service.Services.UserService;


@Service
public class UserServiceImpl implements  UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//byFeinClient
	@Autowired
	private HotelService hotelservice;
	
	private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User saveUser(User user) {
		
		//it will generate unique userId in String format
		String randomUID= UUID.randomUUID().toString();
		user.setUserId(randomUID);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server.."+userId));
		
		//fetch rating of above user from rating service
		//http://localhost:9999/ratings/users/1d093edf-83dd-4f10-8e69-7545196e1bf8
		
		Rating[] ratingsofUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		logger.info("{}",ratingsofUser);
		
		List<Rating> ratings = Arrays.stream(ratingsofUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating ->{
			
			//api call to hotel service to get the hotel     , if we want more information about http then we use getForEntity , otherwise use getForObject
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelservice.getHotel(rating.getHotelId());
			//logger.info("response status code:{} ",forEntity.getStatusCode());
			
			//set the hotel to rating
			rating.setHotel(hotel);
			
			//return the rating
			return rating;
			
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		
		return user;
	}

}
