package project.CarWash.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.CarWash.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer>{

}
