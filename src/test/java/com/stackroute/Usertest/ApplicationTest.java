package com.stackroute.Usertest;


import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.hackathon.Application;
import com.stackroute.hackathon.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest  extends TestCase {
   
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    User user;    
   
    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1);
        user.setEmailId("abhi28@gmail.com");
        user.setUsername("abhijit");
    }
    
   private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
   @After
    public void tearDown() throws Exception {
        user=null;
    }
    
   @Test
    public void testSaveUser() throws Exception { 

       HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Users/user"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User Profile Saved",actual);
    }
    
   @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Users"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
   @Test
    public void testGetUser() throws Exception {
    }
    
   @Test
    public void testUpdateUser() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Users/1?name=abhijit&email=abhi28@gmail.com"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Updated",actual);
    }
    
   @Test
    public void testDeleteUser() throws Exception {
        System.out.println(" sankho"+user.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Users/delete/1"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User Deleted",actual);
    }
    
}