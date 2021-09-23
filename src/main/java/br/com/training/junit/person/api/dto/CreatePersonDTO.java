package br.com.training.junit.person.api.dto;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CreatePersonDTO {

	@NotNull
	private String name;

	@NotNull
	private String city;

	@NotNull
	private String streetName;

	@NotNull
	private Integer old;

}
