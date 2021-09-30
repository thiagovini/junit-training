package br.com.training.junit.person.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CreatePersonCommand {
	
	private final String id;

	private final String name;

	private final String cpf;
	
	private final String city;

	private final String streetName;

}
