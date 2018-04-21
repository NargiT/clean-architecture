package fr.nargit.signup.dao;

import fr.nargit.signup.domain.PersonPortfolio;

import javax.persistence.EntityManager;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public class PersonPortfolioDao extends AbstractDao<PersonPortfolio> {

	public PersonPortfolioDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public PersonPortfolio find(Object id) {
		return entityManager.find(PersonPortfolio.class, id);
	}

	@Override
	public void save(PersonPortfolio target) {
		entityManager.persist(target);
	}
}
