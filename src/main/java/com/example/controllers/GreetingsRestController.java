package com.example.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Greeting;

@RestController
public class GreetingsRestController {
	
	private final AtomicLong counter = new AtomicLong();
	private final Logger logger = LoggerFactory.getLogger(GreetingsRestController.class);
	
	@RequestMapping("/greetings/greeting")
	public String greetings() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/greetings/rest")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), name);
	}
	
	@PostMapping("/greetings/rest")
	public Greeting greeting(@RequestBody Greeting greeting) {
		logger.warn("Greeting received for %s", greeting.getName());
		return new Greeting(counter.incrementAndGet(), greeting.getName());
	}
}
