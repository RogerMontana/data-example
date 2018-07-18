package com.data.dataexample.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.data.dataexample.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	Person findByName(String name);

}
