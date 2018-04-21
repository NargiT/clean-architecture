package fr.nargit.signup.dao;

import fr.nargit.signup.domain.Person;

import javax.persistence.EntityManager;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public class PersonDao extends AbstractDao<Person> {

	public PersonDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Person find(Object id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	public void save(Person target) {
		entityManager.persist(target);
	}
}
