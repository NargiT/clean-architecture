package fr.nargit.signup.dao.impl;

import fr.nargit.signup.dao.PersonDao;
import fr.nargit.signup.dao.impl.AbstractDao;
import fr.nargit.signup.domain.Person;

import javax.persistence.EntityManager;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public class PersonDaoImpl extends AbstractDao<Person> implements PersonDao {

  public PersonDaoImpl(EntityManager entityManager) {
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
