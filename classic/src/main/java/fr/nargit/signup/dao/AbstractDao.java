package fr.nargit.signup.dao;

import javax.persistence.EntityManager;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public abstract class AbstractDao<T> implements GenericDao<T> {

	protected final EntityManager entityManager;

	public AbstractDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
