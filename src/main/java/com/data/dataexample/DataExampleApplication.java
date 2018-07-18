package com.data.dataexample;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.data.dataexample.entity.Person;
import com.data.dataexample.repo.PersonRepository;

@SpringBootApplication
@EnableBinding(Sink.class)
public class DataExampleApplication {

	private PersonRepository personRepository;

	private Function<PersonMessage, Person> convertToEntity = p -> new Person(p.getName());
	private Consumer<Person> saveToDatabase = p -> personRepository.save(p);

	public DataExampleApplication(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataExampleApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(PersonMessage personMessage) {
		System.out.println("Received: " + personMessage);
		saveToDatabase.accept(convertToEntity.apply(personMessage));
	}

	public static class PersonMessage {
		private String name;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return this.name;
		}
	}

}
