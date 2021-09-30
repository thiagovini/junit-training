package br.com.training.junit.person.model;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.training.junit.person.PersonTestFactory;

@SpringBootTest
@ActiveProfiles(profiles = "test")
@Transactional
public class PersonTest {

	@Test
	@DisplayName("Must create a new person.")
	void createNewPerson() {

		// given
		var name = "João";
		var cpf = "321";
		var city = "New York";
		var streetName = "New York Street";

		// when
		var person = Person.builder().name(name).cpf(cpf).city(city).streetName(streetName).build();
		
		//then
		assertThat(person.getName()).isEqualTo(name);
		assertThat(person.getCpf()).isEqualTo(cpf);
		assertThat(person.getCity()).isEqualTo(city);
		assertThat(person.getStreetName()).isEqualTo(streetName);

	}
	
	@Test
	void updatePerson() {
		
		//given
		var city = "Tampa";
		var streetName = "Tampa Street";
		
		var person = PersonTestFactory.onePerson();
		
		//when
		person.updatePerson(city, streetName);
		
		//then
		assertThat(person.getCity()).isEqualTo(city.toUpperCase());
		assertThat(person.getStreetName().toUpperCase()).isEqualTo(streetName.toUpperCase());
		
	}

}
