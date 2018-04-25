package fr.nargit.signup.service;

import fr.nargit.email.api.EmailService;
import fr.nargit.signup.service.dto.SignupData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignupService {

  private LoginService loginService;
  private LinkService linkService;
  private ProfileService profileService;
  private PortfolioService portfolioService;
  private EmailService emailService;

  /**
   * Problems:
   * Hibernate ids leaks and are necessary for service communication
   * Signup data is shared rest api + internal implementation (annotation)
   * Service know about hibernate entites and heavily dependant
   *
   * @param signupData
   */
  public void registerFull(SignupData signupData) {
    final Long personId = this.profileService.createPerson(signupData);
    final String username = this.loginService.createLogin(signupData, personId);
    final Long portfolioId = portfolioService.createPortfolio(signupData);
    linkService.linkAccount(username, personId, portfolioId);

    String html = "content";
    emailService.sendEmail(signupData.getEmail(), "Welcome to clean architecture", html);
  }
}
