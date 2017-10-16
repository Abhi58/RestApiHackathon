package com.stackroute.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.services.UserServiceImpl;





@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping(path="/Users/{id}")
	public @ResponseBody ResponseEntity<User> getbyid (@PathVariable("id") int id) {  

		
		try {
			User user=userService.getById(id);
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}
		catch(Exception e){
			
			User user=null;
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/Users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the News
		 try {
		        Iterable<User> allUsers = userService.getAllUsers();
		        return allUsers;
		        }
		        catch(Exception e) {
		            return null;
		        }
	}
	
	@PostMapping(path="/Users/user", consumes="application/json") // Map ONLY POST Requests
	public @ResponseBody ResponseEntity<String> insertHeadlines (@RequestBody User user)
	{
		   try{
	            userService.addUser(user);
	        return new ResponseEntity<String>("User Profile Saved", HttpStatus.CREATED);
	        }
	        catch(Exception e) {
	            String User="User Details Not Found";
	            return new ResponseEntity<String>(User, HttpStatus.NO_CONTENT);
	        }
    }
	
	@DeleteMapping("/Users/delete/{id}")
	public @ResponseBody ResponseEntity<String> deleteHeadlines (@PathVariable("id") int id) {
		
		  try {
	            userService.deleteUser(id);
	            return new ResponseEntity<String>("User Deleted", HttpStatus.GONE);
	        } 
	        catch(Exception e) {
	            String user="Unable to Delete User";
	            return new ResponseEntity<String>(user, HttpStatus.RESET_CONTENT);
	        }
	}
	
	@PutMapping("/Users/{id}")
	public @ResponseBody ResponseEntity<String> updateHeadlines (@PathVariable("id") int id,@RequestParam String name,@RequestParam String email) {
		try {
	        userService.updateUser(id, name,email);
	        return new ResponseEntity<String>("Updated", HttpStatus.ACCEPTED);
	        }
	        catch(Exception e) {
	            String user="User Not Found";
	            return new ResponseEntity<String>(user, HttpStatus.NOT_IMPLEMENTED);
	        }
		
	}
	
	

}
