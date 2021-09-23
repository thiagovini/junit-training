package br.com.training.junit.person.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.training.junit.person.api.dto.CreatePersonDTO;
import br.com.training.junit.person.application.PersonApplicationService;
import br.com.training.junit.person.application.command.CreatePersonCommand;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = PersonController.PATH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class PersonController {

	public static final String PATH = "/api/v1/person";

	private PersonApplicationService service;

	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody CreatePersonDTO dto) {

		var command = CreatePersonCommand.builder()
		                                 .name(dto.getName())
		                                 .city(dto.getCity())
		                                 .streetName(dto.getStreetName())
		                                 .old(dto.getOld())
		                                 .build();

		service.handle(command);

		return ResponseEntity.ok().build();

	}

}
