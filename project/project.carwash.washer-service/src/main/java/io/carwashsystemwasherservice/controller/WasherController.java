package io.carwashsystemwasherservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.carwashsystem.washerservice.model.Ratings;


import io.carwashsystem.washerservice.model.Washerdetails;
import io.carwashsystemwasherservice.repo.WasherRepository;


@RestController
@RequestMapping("/washer")
public class WasherController {
	
	@Autowired
	private WasherRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addWasher")
	public String addCustomer(@RequestBody Washerdetails customer)
	{
		repository.save(customer);
		return "Added washer with id : " +customer.getId();
	}	
	
	@GetMapping("findAllWashers")	
	public List<Washerdetails> getCustomers(){
		return repository.findAll();			
	}
	
	@GetMapping("findWasher/{id}")
	public Optional<Washerdetails> getCustomer(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("deleteWasher/{id}")
	public String deleteCustomer(@PathVariable int id){
		repository.deleteById(id);
		return "Deleted customer with id : " +id;

	}	
	
	@GetMapping("/allratings")
	public List<Ratings> getallratings(){
		String baseurl="http://localhost:7070/admin/allratings";
		Ratings[] allratings=restTemplate.getForObject(baseurl, Ratings[].class);
		
		return Arrays.asList(allratings);
	}
	
	
	
}
