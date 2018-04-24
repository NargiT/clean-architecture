package fr.nargit.signup.dao;

import fr.nargit.signup.domain.Portfolio;

import javax.persistence.EntityManager;

public class PortfolioDao extends AbstractDao<Portfolio> {
	public PortfolioDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Portfolio find(Object id) {
		return entityManager.find(Portfolio.class, id);
	}

	@Override
	public void save(Portfolio target) {
		entityManager.persist(target);
	}
}
