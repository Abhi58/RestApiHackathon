package com.stackroute.hackathon.services;


import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exception.UserAlreadyExistsException;
import com.stackroute.hackathon.exception.UserNotFoundException;

public interface UserServiceInterface {

	public User getById(int id) throws UserNotFoundException ;
	public Iterable<User> getAllUsers();
	public User addUser(User user) throws UserAlreadyExistsException;
	public String deleteUser(int id) throws UserNotFoundException;
	public String updateUser(int id, String name,String email) throws UserNotFoundException;
}
