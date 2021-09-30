package br.com.training.junit.person.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public final class DeletePersonCommand {
	
	private final String id;

}
