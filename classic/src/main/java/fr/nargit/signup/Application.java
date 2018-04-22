package fr.nargit.signup;

import fr.nargit.email.api.EmailService;
import fr.nargit.password.api.PasswordService;
import fr.nargit.signup.dao.LoginDao;
import fr.nargit.signup.dao.PersonDao;
import fr.nargit.signup.dao.PersonPortfolioDao;
import fr.nargit.signup.dao.PortfolioDao;
import fr.nargit.signup.service.*;
import fr.nargit.signup.service.dto.SignupData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Application {

  private EntityManager entityManager;
  private LoginDao loginDao;
  private PersonDao personDao;
  private PortfolioDao portfolioDao;
  private PersonPortfolioDao personPortfolioDao;

  private LoginService loginService;
  private ProfileService profileService;
  private PortfolioService portfolioService;
  private LinkService linkService;
  private PasswordService passwordService;
  private EmailService emailService;
  private SignupService signupService;

  private void init() {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fr.nargit.domain");
    this.entityManager = entityManagerFactory.createEntityManager();

    this.loginDao = new LoginDao(entityManager);
    this.personDao = new PersonDao(entityManager);
    this.portfolioDao = new PortfolioDao(entityManager);
    this.personPortfolioDao = new PersonPortfolioDao(entityManager);

    this.profileService = new ProfileService(personDao);
    this.portfolioService = new PortfolioService(portfolioDao);
    this.linkService = new LinkService(personPortfolioDao);
    this.passwordService = new PasswordService() {
      @Override
      public void generatePassord(String username) {

      }
    };
    this.loginService = new LoginService(loginDao, passwordService);
    this.emailService = new EmailService() {
      @Override
      public void sendEmail(String email, String subject, String content) {

      }
    };
    this.signupService = new SignupService(loginService, linkService, profileService, portfolioService, emailService);
  }

  public void start() {
    init();
    entityManager.getTransaction().begin();
    final SignupData signupData = SignupData.builder()
        .firstname("tig")
        .lastName("tch")
        .email("tig.tch@nargit.fr")
        .birthDate(new Date())
        .type("TRADING")
        .build();
    try {
      signupService.registerFull(signupData);
      entityManager.getTransaction().commit();
    } catch (Exception e){
      entityManager.getTransaction().rollback();
    } finally {
      entityManager.close();
    }
  }
}
