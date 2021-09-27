package br.com.training.junit.person.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
public final class getPersonByCityAndNameStartWithCommand {
	
	private final String city;
	private final String nameStartWith;

}
