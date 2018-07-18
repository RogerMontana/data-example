package com.data.dataexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by Artem Karpov
 */
public class Person {

	@Id
	public String id;

	@Indexed
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format(
				"Person[id=%s, name='%s'']", id, name);
	}
}