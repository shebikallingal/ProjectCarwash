package io.carwashsystemadminservice.controller;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;

import io.carwashsystem.adminservice.logger.GlobalLogger;
import io.carwashsystem.adminservice.model.Admindetails;
import io.carwashsystem.adminservice.model.Ratings;
import io.carwashsystemadminservice.repo.AdminRepository;
import io.carwashsystemadminservice.repo.RatingRepository;
import io.swagger.models.HttpMethod;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private Logger logger = GlobalLogger.getLogger(AdminController.class);
	
	@Autowired
	  RestTemplate restTemplate;
	
	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private RatingRepository repo2;
	
	@GetMapping("/findAllCustomers")
	   public List<Object> getCustomerList() {
		
		String url = "http://USER-SERVICE/customer";
		Object[] objects = restTemplate.getForObject(url+"/findAllCustomers",Object[].class);
		
		return Arrays.asList(objects);
	   }
	//logger.info("Succefuly fetched");
	@PostMapping("/addAdmnin")
	public String addCustomer(@RequestBody Admindetails customer)
	{
		repository.save(customer);
		return "Added customer with id : " +customer.getId();
	}	
	
	@GetMapping("findAllAdmin")	
	public List<Admindetails> getAdmins(){
		return repository.findAll();			
	}
	
	@GetMapping("findAdmin/{id}")
	public Optional<Admindetails> getAdmin(@PathVariable int id){
		return repository.findById(id);
	}
	
	
	@DeleteMapping("deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable int id){
		repository.deleteById(id);
		return "Deleted admin with id : " +id;

	}	
	@PostMapping("/addrating")
	public String saverating(@RequestBody Ratings rating)
	{
		repo2.save(rating);
		return " Thanks for Your Valuable feedback";
	}
	@GetMapping("/allratings")
	public List<Ratings> getuser()
	{
		return repo2.findAll();
	}
	
	
}
