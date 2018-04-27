package fr.nargit.signup.service;

import fr.nargit.password.api.PasswordService;
import fr.nargit.signup.dao.LoginDao;
import fr.nargit.signup.domain.Login;
import fr.nargit.signup.service.dto.SignupData;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    loginService.createLogin(SignupData.builder().firstname("jean").lastName("mark").build(), 2L);

    ArgumentCaptor<Login> argumentCaptor = ArgumentCaptor.forClass(Login.class);
    Mockito.verify(loginDao).save(argumentCaptor.capture());

    final Login value = argumentCaptor.getValue();
    Assert.assertThat(value.getPersonId(), CoreMatchers.is(2L));
    Assert.assertThat(value.getUsername().charAt(0), CoreMatchers.is('j'));
    Assert.assertThat(value.getUsername().substring(1, 4), CoreMatchers.is("mar"));
    Assert.assertTrue(value.getUsername().substring(4, 8).matches("[0-9]{4}"));
  }
}