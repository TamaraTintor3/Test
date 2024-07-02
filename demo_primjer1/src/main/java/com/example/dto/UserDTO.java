package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private String cityOrLocation;
	
	private String countryCode;

	@NotBlank(message = "Email is required field!")
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String organization;
	
	private String organizationUnit;
	
	private String stateOrProvince;

	@NotBlank(message = "Username is required field!")
	private String username; 
	
	private String status;
}
