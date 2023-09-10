package com.hotel.service.Services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.Entities.Hotel;
import com.hotel.service.Exceptions.ResourceNotFoundException;
import com.hotel.service.Repositories.HotelRepository;
import com.hotel.service.Services.HotelService;


@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomUID= UUID.randomUUID().toString();
		hotel.setId(randomUID);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hoteId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hoteId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found...."));
	}

}
