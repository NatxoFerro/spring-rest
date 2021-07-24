package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repos.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer addCustomer(String name, String surname) {
		Customer customer = new Customer(name, surname);
		return customerRepo.save(customer);
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Iterable<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	public Optional<Customer> getCustomerById(Long id) {
		return customerRepo.findById(id);
	}
	
	public List<Customer> getCustomerBySurname(String surname) {
		return customerRepo.findByLastName(surname);
	}
}
