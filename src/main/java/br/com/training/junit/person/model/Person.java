package br.com.training.junit.person.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {

	@Id
	private String id;

	private String name;

	private String city;

	private String streetName;

	private Integer old;

}
