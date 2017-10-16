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

import io.swagger.annotations.Api;




//<----Controller Class---->
@RestController
@Api(value="User Details", description="Operations Pertaining to User information")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	//<---Methods to Fetch Details of User using service -->
	@GetMapping(path="/Users/{id}")
	public @ResponseBody ResponseEntity<?> getbyid (@PathVariable("id") int id) {  

		
		try {
			User user=userService.getById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		catch(Exception e){
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(path="/Users")
	   public @ResponseBody ResponseEntity<?> getAllUsers() { 
        try {
            return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
        }
        catch(Exception e) { 
            return  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	
	//<--- Method to create a new user using service ---->
	@PostMapping(path="/Users/user", consumes="application/json") // Map ONLY POST Requests
	public @ResponseBody ResponseEntity<?> insertUser(@RequestBody User user)
	{
        try {
            if(user.getEmailId() == null || user.getUsername() == null) return new ResponseEntity<String>("Enter valid name and email Id", HttpStatus.BAD_REQUEST);
            userService.addUser(user);
            return new ResponseEntity<String>("User Profile Saved", HttpStatus.OK);
        }
        catch(Exception e) { 
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
	
	//<--- Method to delete a user using service -->
	@DeleteMapping("/Users/delete/{id}")
	public @ResponseBody ResponseEntity<String> removeUser (@PathVariable("id") int id) {
		
		  try {
	            userService.deleteUser(id);
	            return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	        } 
	        catch(Exception e) {
	            String user=e.getMessage();
	            return new ResponseEntity<String>(user, HttpStatus.OK);
	        }
	}
	
	
	//<--- Method to update user details using service --->
	@PutMapping("/Users/{id}")
	public @ResponseBody ResponseEntity<String> updateHeadlines (@PathVariable("id") int id,@RequestParam String name,@RequestParam String email) {
		try {
			User user=userService.getById(id);
			if(user.getEmailId() == null || user.getUsername() == null) return new ResponseEntity<String>("Enter valid name and email Id", HttpStatus.BAD_REQUEST);
	        return new ResponseEntity<String>(userService.updateUser(id, name,email), HttpStatus.OK);
	        }
	        catch(Exception e) {
	            String user=e.getMessage();
	            return new ResponseEntity<String>(user, HttpStatus.NOT_IMPLEMENTED);
	        }
		
	}
	
	

}
