package br.com.training.junit.person.application.command;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CreatePersonCommand {

	@NotNull
	private final String name;

	@NotNull
	private final String cpf;
	
	@NotNull
	private final String city;

	@NotNull
	private final String streetName;

}
