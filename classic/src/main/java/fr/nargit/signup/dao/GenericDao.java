package fr.nargit.signup.dao;

/**
 * (c) Swissquote 22-avr.-2018
 *
 * @author Tigran
 */
public interface GenericDao<T> {

	T find(Object id);

	void save(T target);
}
