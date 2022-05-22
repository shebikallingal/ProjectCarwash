package io.carwashsystemadminservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.carwashsystem.adminservice.model.Admindetails;



public interface AdminRepository extends MongoRepository<Admindetails, Integer> {


}