package com.stackroute.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.hackathon.domain.User;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
	
	

}
