package br.com.training.junit.person.application;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.junit.person.application.command.CreatePersonCommand;
import br.com.training.junit.person.application.command.DeletePersonCommand;
import br.com.training.junit.person.application.command.UpdatePersonCommand;
import br.com.training.junit.person.application.command.getPersonByCityAndNameStartWithCommand;
import br.com.training.junit.person.application.command.getPersonByCityCommand;
import br.com.training.junit.person.application.command.getPersonByStreetNameCommand;
import br.com.training.junit.person.model.Person;
import br.com.training.junit.person.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PersonApplicationService {

	@Autowired
	private PersonRepository repository;

	public String handle(CreatePersonCommand command) {

		var person = Person.builder()
		                   .id(UUID.randomUUID().toString())
		                   .name(command.getName())
		                   .cpf(command.getCpf())
		                   .city(command.getCity())
		                   .streetName(command.getStreetName())
		                   .build();

		repository.save(person);

		return person.getId();

	}

	public void handle(DeletePersonCommand command) throws Exception {

		var person = repository.findById(command.getId());

		if (person.isPresent()) {

			repository.delete(person.get());

		} else {

			throw new Exception("Person not found");

		}

	}

	public List<Person> handle(getPersonByCityCommand command) {

		var people = repository.findByCityContains(command.getCity().toUpperCase());

		return people.stream()
		             .map(person -> Person.builder()
		                                  .id(person.getId())
		                                  .name(person.getName())
		                                  .cpf(person.getCpf())
		                                  .city(person.getCity())
		                                  .streetName(person.getStreetName())
		                                  .build())
		             .collect(Collectors.toList());

	}

	public List<Person> handle(getPersonByStreetNameCommand command) {

		var people = repository.findByStreetNameContains(command.getStreetName().toUpperCase());

		return people.stream()
		             .map(person -> Person.builder()
		                                  .id(person.getId())
		                                  .name(person.getName())
		                                  .cpf(person.getCpf())
		                                  .city(person.getCity())
		                                  .streetName(person.getStreetName())
		                                  .build())
		             .collect(Collectors.toList());

	}

	public List<Person> handle(getPersonByCityAndNameStartWithCommand command) {

		var people = repository.findByCityAndNameStartWith(command.getCity().toUpperCase(),
		                                                   command.getNameStartWith() + "%");

		return people.stream()
		             .map(person -> Person.builder()
		                                  .id(person.getId())
		                                  .name(person.getName())
		                                  .cpf(person.getCpf())
		                                  .city(person.getCity())
		                                  .streetName(person.getStreetName())
		                                  .build())
		             .collect(Collectors.toList());

	}

	public void handle(UpdatePersonCommand command) throws Exception {

		var person = repository.findById(command.getId());

		if (!person.isPresent()) {

			throw new Exception("Person not found!");

		} else {

			person.get().updatePerson(command.getCity(), command.getStreetName());

			repository.saveAndFlush(person.get());
		}

	}

}
