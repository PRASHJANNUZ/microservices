package com.hotel.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.Entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
