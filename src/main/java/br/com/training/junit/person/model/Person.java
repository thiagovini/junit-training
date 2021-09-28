package br.com.training.junit.person.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

	private static final long serialVersionUID = -8310024765867170219L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Person.name.notBlank")
	private String name;

	@NotBlank(message = "Person.cpf.notBlank")
	private String cpf;

	@NotBlank(message = "Person.city.notBlank")
	private String city;

	@NotBlank(message = "Person.streetName.notBlank")
	@Column(name = "street_name")
	private String streetName;

}
