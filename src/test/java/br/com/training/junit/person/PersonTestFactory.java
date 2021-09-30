package br.com.training.junit.person;

import java.util.UUID;

import br.com.training.junit.person.model.Person;
import br.com.training.junit.person.repository.PersonRepository;

public class PersonTestFactory {

	public static Person persist(PersonRepository repository, Person person) {
		repository.save(person);
		return person;
	}

	public static Person.PersonBuilder onePersonBuild() {
		return Person.builder()
		             .id(UUID.randomUUID().toString())
		             .name("Thiago")
		             .cpf("123")
		             .city("Joinville")
		             .streetName("Test Street");
	}

	public static Person onePerson() {
		return onePersonBuild().build();
	}

}
