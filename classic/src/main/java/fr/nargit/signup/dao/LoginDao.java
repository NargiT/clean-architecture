package fr.nargit.signup.dao;

import fr.nargit.signup.domain.Login;

import javax.persistence.EntityManager;

public class LoginDao extends AbstractDao<Login> {

	public LoginDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Login find(Object id) {
		return entityManager.find(Login.class, id);
	}

	@Override
	public void save(Login target) {
		entityManager.persist(target);
	}

}
