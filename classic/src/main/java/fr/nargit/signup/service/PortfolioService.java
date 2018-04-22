package fr.nargit.signup.service;

import fr.nargit.signup.dao.PortfolioDao;
import fr.nargit.signup.domain.Portfolio;
import fr.nargit.signup.service.dto.SignupData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PortfolioService {

  private PortfolioDao portfolioDao;

  public Long createPortfolio(SignupData signupData) {
    final String type = signupData.getType();
    Long portfolioType ;
    if ("TRADING".equals(type)) {
      portfolioType = 1L;
    } else {
      throw new IllegalArgumentException("Do not support other than TRADING portfolio");
    }
    final int aNew = 1;
    final Portfolio portfolio = Portfolio.builder()
        .status(aNew)
        .type(portfolioType)
        .build();

    portfolioDao.save(portfolio);

    return portfolio.getPortfolioId();
  }
}
