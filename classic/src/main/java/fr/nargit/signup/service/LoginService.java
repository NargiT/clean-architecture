package fr.nargit.signup.service;

import fr.nargit.password.api.PasswordService;
import fr.nargit.signup.dao.LoginDao;
import fr.nargit.signup.domain.Login;
import fr.nargit.signup.service.dto.SignupData;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class LoginService {

  private LoginDao loginDao;
  private PasswordService secureService;

  public String createLogin(SignupData signupData, Long personId) {
    final String username = generateUsername(signupData.getFirstname().substring(0, 1), signupData.getLastName().substring(0, 3));
    final Login login = new Login(username, personId);
    loginDao.save(login);
    secureService.generatePassord(username);
    return username;
  }

  private String generateUsername(String firstNameLetter, String lastnameLetters) {
    return firstNameLetter
        + lastnameLetters
        + generateNumbers()
        + generateNumbers()
        + generateNumbers()
        + generateNumbers();
  }

  private Integer generateNumbers() {
    Random rand = new Random();
    return rand.nextInt(9) + 1;
  }
}
