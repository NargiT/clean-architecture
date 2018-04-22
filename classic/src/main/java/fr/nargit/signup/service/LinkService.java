package fr.nargit.signup.service;

import fr.nargit.signup.dao.PersonPortfolioDao;
import fr.nargit.signup.domain.PersonPortfolio;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LinkService {

  private PersonPortfolioDao personPortfolioDao;

  public void linkAccount(String username, Long personId, Long portfolioId) {
    final PersonPortfolio personPortfolio = PersonPortfolio.builder()
        .username(username)
        .personId(personId)
        .portfolioId(portfolioId)
        .visible(true)
        .build();

    personPortfolioDao.save(personPortfolio);
  }
}

