package com.example.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Greeting;

@Controller
public class GreetingsWebController {

	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greetings/web")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("greeting", new Greeting(counter.incrementAndGet(), name));
		return "greeting";
	}

}
