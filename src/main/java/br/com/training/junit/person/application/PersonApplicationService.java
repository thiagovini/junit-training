package br.com.training.junit.person.application;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.training.junit.person.application.command.CreatePersonCommand;
import br.com.training.junit.person.model.Person;
import br.com.training.junit.person.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PersonApplicationService {

	private PersonRepository repository;

	public String handle(CreatePersonCommand command) {

		var pessoa = Person.builder()
		                   .id(UUID.randomUUID().toString())
		                   .name(command.getName())
		                   .city(command.getCity())
		                   .streetName(command.getStreetName())
		                   .old(command.getOld())
		                   .build();

		repository.saveAndFlush(pessoa);

		return pessoa.getId();

	}

}
