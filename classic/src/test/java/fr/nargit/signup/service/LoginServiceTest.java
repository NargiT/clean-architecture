package fr.nargit.signup.service;

import fr.nargit.password.api.PasswordService;
import fr.nargit.signup.dao.LoginDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

  @Mock
  private LoginDao loginDao;

  @Mock
  private PasswordService passwordService;

  @InjectMocks
  private LoginService loginService;

  @Test
  public void createLogin() {
  }
}