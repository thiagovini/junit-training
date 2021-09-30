package br.com.training.junit.person.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@NotBlank(message = "Person.id.notBlank")
	private String id;

	@NotBlank(message = "Person.name.notBlank")
	private String name;

	@NotBlank(message = "Person.cpf.notBlank")
	private String cpf;

	@NotBlank(message = "Person.city.notBlank")
	private String city;

	@NotBlank(message = "Person.streetName.notBlank")
	@Column(name = "street_name")
	private String streetName;

	public Person updatePerson(String city, String streetName) {
		
		if (city != null)
			this.city = city.toUpperCase();

		if (streetName != null)
			this.streetName = streetName.toUpperCase();

		return this;

	}

}
