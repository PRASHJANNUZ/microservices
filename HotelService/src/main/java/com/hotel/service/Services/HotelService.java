package com.hotel.service.Services;

import java.util.List;

import com.hotel.service.Entities.Hotel;

public interface HotelService {

	//create
	Hotel saveHotel(Hotel hotel);
	
	//get All
	List<Hotel> getAllHotels();
	
	//get Single
	Hotel getHotel(String hotelId);
	
}
