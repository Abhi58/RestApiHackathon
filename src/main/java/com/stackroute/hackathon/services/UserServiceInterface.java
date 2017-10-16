package com.stackroute.hackathon.services;


import com.stackroute.hackathon.domain.User;

public interface UserServiceInterface {

	public User getById(int id);
	public Iterable<User> getAllUsers();
	public User addUser(User user);
	public void deleteUser(int id);
	public void updateUser(int id, String name,String email);
}
