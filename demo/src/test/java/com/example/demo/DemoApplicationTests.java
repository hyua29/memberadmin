package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private RestTemplate restTemplate;
    private String baseUrl;
    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:8080/api/";
    }

    @Test
    public void contextLoads() {
    }

    /**
     * Check whether GET API for club collections is available
     */
    @Test
    public void isClubControllerAvailable() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl + "/clubs/", String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    /**
     * Check whether GET API for member collections is available
     */
    @Test
    public void isMemberControllerAvailable() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl + "/members/", String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
