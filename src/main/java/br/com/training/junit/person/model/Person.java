package br.com.training.junit.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Person {

	@Id
	private String id;

	private String name;

	private String city;

	@Column(name = "street_name")
	private String streetName;

	private Integer old;

}
