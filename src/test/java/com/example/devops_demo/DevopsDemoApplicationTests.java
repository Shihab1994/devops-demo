package com.example.devops_demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DevopsDemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testHelloEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
		assertEquals("Hello from DevOps Demo!", response.getBody());
	}

	@Test
	void testGreetEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/greet?name=Alice", String.class);
		assertEquals("Hello, Alice!", response.getBody());
	}

	@Test
	void testStatusEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/status", String.class);
		assertEquals("Application is running!", response.getBody());
	}
}
