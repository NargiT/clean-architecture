package fr.nargit.signup.dao.impl;

import fr.nargit.signup.dao.LoginDao;
import fr.nargit.signup.domain.Login;

import javax.persistence.EntityManager;

public class LoginDaoImpl extends AbstractDao<Login> implements LoginDao {

	public LoginDaoImpl(EntityManager entityManager) {
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
