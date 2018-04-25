package fr.nargit.signup.dao.impl;

import fr.nargit.signup.dao.PortfolioDao;
import fr.nargit.signup.domain.Portfolio;

import javax.persistence.EntityManager;

public class PortfolioDaoImpl extends AbstractDao<Portfolio> implements PortfolioDao {
  public PortfolioDaoImpl(EntityManager entityManager) {
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
