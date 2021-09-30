package br.com.training.junit.person.application;

import static br.com.training.junit.person.PersonTestFactory.onePerson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.training.junit.person.PersonTestFactory;
import br.com.training.junit.person.application.command.CreatePersonCommand;
import br.com.training.junit.person.application.command.DeletePersonCommand;
import br.com.training.junit.person.repository.PersonRepository;

@SpringBootTest
@ActiveProfiles(profiles = "test")
@Transactional
class PersonApplicationTest {

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonApplicationService service;

	@Test
	@DisplayName("Must create a new person.")
	void mustCreatePerson() {

		// given
		var person = onePerson();

		var command = CreatePersonCommand.builder()
		                                 .id(person.getId())
		                                 .name(person.getName())
		                                 .cpf(person.getCpf())
		                                 .city(person.getCity())
		                                 .streetName(person.getStreetName())
		                                 .build();

		// when
		var id = service.handle(command);

		// then
		var persistedPerson = repository.findById(id).get();

		assertNotNull(persistedPerson);
		assertThat(persistedPerson.getId()).isEqualTo(id);
		assertThat(persistedPerson.getName()).isEqualTo(person.getName());
		assertThat(persistedPerson.getCpf()).isEqualTo(person.getCpf());
		assertThat(persistedPerson.getCity()).isEqualTo(person.getCity());
		assertThat(persistedPerson.getStreetName()).isEqualTo(person.getStreetName());

	}

	@Test
	@DisplayName("Must create a new person.")
	void mustDeletePerson() throws Exception {

		// given
		var person = PersonTestFactory.persist(repository, PersonTestFactory.onePerson());

		var command = DeletePersonCommand.of(person.getId());

		// when
		service.handle(command);

		// then
		var persistedPerson = repository.findById(person.getId());

		assertTrue(persistedPerson.isEmpty());

	}

}
