package br.com.training.junit.person.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CreatePersonDTO {

	private final String name;

	private final String cpf;

	private final String city;

	private final String streetName;

}
