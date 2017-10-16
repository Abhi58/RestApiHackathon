/*package com.stackroute.newsaggregatortest;


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
import com.stackroute.hackathon.domain.News;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest  extends TestCase {
   
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	News News;    
    
	@Before
    public void setUp() throws Exception {
		News = new News(16,"DarkKnight");
    }
	
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSaveNews() throws Exception { 

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<News> entity = new HttpEntity<News>(News, headers); 
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/SavedHeadlines?name=TheHindu"),
                HttpMethod.POST, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Headlines Saved",actual);
    }
    
    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/SavedHeadlines"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
    @Test
    public void testGetNews() throws Exception {
    }
    
    @Test
    public void testUpdateNews() throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<News> entity = new HttpEntity<News>(News, headers); 
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/SavedHeadlines/3?name=something"),
                HttpMethod.PUT, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Updated",actual);
    }
    
    @Test
    public void testDeleteNews() throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<News> entity = new HttpEntity<News>(News, headers); 
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/SavedHeadlines/77"),
                HttpMethod.DELETE, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Headlines Deleted",actual);
    }
    
}*/