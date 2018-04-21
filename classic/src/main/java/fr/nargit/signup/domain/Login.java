package fr.nargit.signup.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGINS")
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "person_id")
	private Long personId;
}
