package com.stackroute.hackathon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.repository.UserRepository;



@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		User user=userRepository.findOne(id);
		return user;
	}



	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User user1=new User();
		return userRepository.save(user1);
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

	@Override
	public void updateUser(int id, String name,String email) {
		// TODO Auto-generated method stub
		
		User user=userRepository.findOne(id);
		user.setUsername(name);
		user.setEmailId(email);
		userRepository.save(user);
		
	}

}
