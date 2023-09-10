package com.rating.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.Entities.Rating;
import com.rating.service.Services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	//create
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating r)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(r));
	}
	
	//getAll
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatigs());
	}
	
	
	//get Rating by USerID
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));

	}
	
	//get Rating by HotelID
		@GetMapping("/hotels/{hoteId}")
		public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hoteId)
		{
			return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hoteId));
		}
	
	
}
