package br.com.training.junit.person.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePersonCommand {

	private final String id;

	private final String city;

	private final String streetName;

}
