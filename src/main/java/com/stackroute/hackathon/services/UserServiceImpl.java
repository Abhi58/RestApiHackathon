package com.stackroute.hackathon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exception.UserAlreadyExistsException;
import com.stackroute.hackathon.exception.UserNotFoundException;
import com.stackroute.hackathon.repository.UserRepository;


//<--- User Service class --->
@Service
public class UserServiceImpl implements UserServiceInterface {
	
	
	@Autowired
	private UserRepository userRepository;

	//<--- Setter and Getter Methods for Repository class --->
	public UserRepository getUserRepository() {
		return userRepository;
	}



	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	
	//<-- Method to get user from repopsitory by Id -->

	@Override
	public User getById(int id) throws UserNotFoundException {
		
		
			// TODO Auto-generated method stub
			User user=userRepository.findOne(id);
			if(user == null) throw new UserNotFoundException("User with ID:"+id+" not found!"); 
			return user;
		
		
	}



	//<-- Method to get All Users from database --->
	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	//<--- Method to create a new user --->
	@Override
	public User addUser(User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
	    if(userRepository.exists(user.getId())) throw new UserAlreadyExistsException("User Already Exists!");
		return userRepository.save(user);
		
	}

	//<--- Method to delete a user from database by Id -->
	@Override
	public String deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		   User user=getById(id);
		   if(!userRepository.exists(user.getId())) throw new UserNotFoundException("Couldn't delete user. User with ID:"+id+" not found!"); 
	        userRepository.delete(user);
	        return "User deleted successfully";
		
	}
	
	
 
	//<--- Method to update user details --->
	@Override
	public String updateUser(int id, String name,String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		User user=userRepository.findOne(id);
		 if(!userRepository.exists(user.getId())) throw new UserNotFoundException("Couldn't update user. User with ID"+id+" not found!");
		    user.setUsername(name);
			user.setEmailId(email);
			userRepository.save(user);
	        return "User Updated Successfully";
		
	}

}
