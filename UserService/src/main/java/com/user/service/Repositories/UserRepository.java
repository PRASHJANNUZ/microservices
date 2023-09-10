package com.user.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.Entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	//if u want to implement any custom methods or query write here
}
