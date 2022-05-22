package project.CarWash.Controller;

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

import project.CarWash.Repository.CustomerRepository;
import project.CarWash.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer)
	{
		repository.save(customer);
		return "Added customer with id : " +customer.getId();
	}	
	
	@GetMapping("findAllCustomers")	
	public List<Customer> getCustomers(){
		return repository.findAll();			
	}
	
	@GetMapping("findCustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("deleteCustomers/{id}")
	public String deleteCustomer(@PathVariable int id){
		repository.deleteById(id);
		return "Deleted customer with id : " +id;

	}	
}
