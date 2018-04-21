package fr.nargit.signup.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS_PORTFOLIOS")
public class PersonPortfolio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "portfolio_id")
	private String portfolioId;

	@Column(name = "person_id")
	private Long personId;

	@Column(name = "visible")
	private boolean visible;
}
