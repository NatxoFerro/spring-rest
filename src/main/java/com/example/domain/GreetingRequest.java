package com.example.domain;

public class GreetingRequest {

	private final String name;

	public GreetingRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
