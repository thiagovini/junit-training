package br.com.training.junit.person.api.dto;

import lombok.Data;

@Data
public final class UpdatePersonDTO {
	
	private final long id;
	
	private final String city;
	
	private final String streetName;
	
	

}
