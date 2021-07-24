package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.services.CustomerService;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/add")
	public Customer addNewUser(@RequestParam String name, @RequestParam(required = false) String surname) {
		return customerService.addCustomer(name, surname);
	}

	@PostMapping(path = "/addit")
	public Customer addNewUser(@RequestBody Customer user) {
		return customerService.addCustomer(user);
	}
	
	@GetMapping(path = "/all")
	public Iterable<Customer> getAllUsers() {
		return customerService.getCustomers();
	}
	
	@GetMapping(value = "/{customerId}")
    public Optional<Customer> getUser(@PathVariable Long customerId) {
		return customerService.getCustomerById(customerId);
    }
	
	@GetMapping(path = "/one")
	public Optional<Customer> getOneUser(@RequestParam(value = "id", required = true) Long id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping(path = "/some")
	public List<Customer> getUserBySurname(@RequestParam(value = "surname", required = true) String surname) {
		return customerService.getCustomerBySurname(surname);
	}
}
