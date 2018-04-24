package fr.nargit.signup.domain;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PORTFOLIOS")
@Builder
@Getter
public class Portfolio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "portfolio_id")
	private Long portfolioId;

	@Column(name = "type")
	private Long type;

	@Column(name = "status")
	private Integer status;
}
