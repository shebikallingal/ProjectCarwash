package io.carwashsystemwasherservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.carwashsystem.washerservice.model.Washerdetails;

public interface WasherRepository extends MongoRepository<Washerdetails, Integer> {

	//Userdetails findByName(String name);


}