package com.example.restservice;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.domain.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest // or @WebMvcTest (only web layers)
@AutoConfigureMockMvc
public class GreetingsRestControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greetings/greeting").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
	
	@Test
	public void getGreetingWithoutName() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greetings/rest").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":3,\"name\":\"World\"}")));
	}
	
	@Test
	public void getGreetingWithName() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greetings/rest?name=Nacho").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"Nacho\"}")));
	}
	
	@Test
	public void postGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/greetings/rest")
				.content(new ObjectMapper().writeValueAsString(new Greeting(1L, "Nacho")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":2,\"name\":\"Nacho\"}")));
	}
}