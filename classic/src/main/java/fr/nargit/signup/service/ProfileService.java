package fr.nargit.signup.service;

import fr.nargit.signup.dao.PersonDao;
import fr.nargit.signup.dao.impl.PersonDaoImpl;
import fr.nargit.signup.domain.Person;
import fr.nargit.signup.service.dto.SignupData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfileService {

  private PersonDao personDao;

  public Long createPerson(SignupData signupData) {
    final Person person = Person.builder()
        .firstname(signupData.getFirstname())
        .lastname(signupData.getLastName())
        .birthDate(signupData.getBirthDate())
        .email(signupData.getEmail())
        .build();

    personDao.save(person);
    return person.getPersonId();
  }

}
