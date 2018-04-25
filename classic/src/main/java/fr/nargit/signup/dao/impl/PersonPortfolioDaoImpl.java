package fr.nargit.signup.dao.impl;

import fr.nargit.signup.dao.PersonPortfolioDao;
import fr.nargit.signup.domain.PersonPortfolio;

import javax.persistence.EntityManager;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public class PersonPortfolioDaoImpl extends AbstractDao<PersonPortfolio> implements PersonPortfolioDao
{

	public PersonPortfolioDaoImpl(EntityManager entityManager) {
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
