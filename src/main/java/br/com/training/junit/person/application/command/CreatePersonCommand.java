package br.com.training.junit.person.application.command;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CreatePersonCommand {

	@NotNull
	private String name;

	@NotNull
	private String city;

	@NotNull
	private String streetName;

	@NotNull
	private Integer old;

}
