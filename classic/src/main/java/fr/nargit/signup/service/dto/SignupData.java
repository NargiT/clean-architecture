package fr.nargit.signup.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class SignupData {

	// profile
	private String firstname;
	private String lastName;
	private Date birthDate;
	private String email;

	// portfolio
	private String type;
}
