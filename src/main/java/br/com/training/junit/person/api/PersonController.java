package br.com.training.junit.person.api;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.training.junit.person.api.dto.CreatePersonDTO;
import br.com.training.junit.person.application.PersonApplicationService;
import br.com.training.junit.person.application.command.CreatePersonCommand;
import br.com.training.junit.person.application.command.DeletePersonCommand;
import br.com.training.junit.person.application.command.getPersonByCityAndNameStartWithCommand;
import br.com.training.junit.person.application.command.getPersonByCityCommand;
import br.com.training.junit.person.application.command.getPersonByStreetNameCommand;
import br.com.training.junit.person.model.Person;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = PersonController.PATH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class PersonController {

	public static final String PATH = "/api/v1/person";

	private PersonApplicationService service;

	@ApiOperation(value = "Person registration.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful person registration."),
	        @ApiResponse(code = 400, message = "Error person registration.") })
	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody CreatePersonDTO dto) {

		var command = CreatePersonCommand.builder()
		                                 .name(dto.getName())
		                                 .cpf(dto.getCpf())
		                                 .city(dto.getCity().toUpperCase())
		                                 .streetName(dto.getStreetName().toUpperCase())
		                                 .build();

		service.handle(command);

		return ResponseEntity.ok().build();

	}

	@ApiOperation(value = "Delete person.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful delete person."),
	        @ApiResponse(code = 400, message = "Error delete person") })
	@PostMapping(path = "/{id}/delete", consumes = ALL_VALUE)
	public ResponseEntity<Void> delete(@PathVariable int id) {

		service.handle(DeletePersonCommand.of(id));

		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "find person by city.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful find person."),
	        @ApiResponse(code = 400, message = "Error find person") })
	@PostMapping(path = "/{city}/filter", consumes = ALL_VALUE)
	public List<Person> getPersonByCity(@RequestParam String city) {

		var command = getPersonByCityCommand.of(city);

		return service.handle(command);

	}

	@ApiOperation(value = "find person by street name.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful find person."),
	        @ApiResponse(code = 400, message = "Error find person") })
	@PostMapping(path = "/{streetName}/filter", consumes = ALL_VALUE)
	public List<Person> getPersonByStreetName(@RequestParam String streetName) {

		var command = getPersonByStreetNameCommand.of(streetName);

		return service.handle(command);

	}

	@ApiOperation(value = "find person by city and name start with.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful find person."),
	        @ApiResponse(code = 400, message = "Error find person") })
	@PostMapping(path = "/{city}/{nameStartWith}/filter", consumes = ALL_VALUE)
	public List<Person> getPersonByCityAndNameStartWith(@RequestParam String city, @RequestParam String nameStartWith) {

		var command = getPersonByCityAndNameStartWithCommand.of(city, nameStartWith);

		return service.handle(command);

	}

}
