package fr.nargit.signup.service;

import fr.nargit.signup.dao.PortfolioDao;
import fr.nargit.signup.domain.Portfolio;
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

/**
 * (c) Swissquote 24-avr.-2018
 *
 * @author Tigran
 */
@RunWith(MockitoJUnitRunner.class)
public class LinkServiceTest {

  @Mock
  private PortfolioDao portfolioDao;

  @InjectMocks
  private PortfolioService portfolioService;

  @Test
  public void linkAccountSuccessTest() {

    // given
    SignupData trading = SignupData.builder()
        .type("TRADING")
        .build();

    // when
    final Long portfolioId = portfolioService.createPortfolio(trading);

    ArgumentCaptor<Portfolio> argumentCaptor = ArgumentCaptor.forClass(Portfolio.class);
    Mockito.verify(portfolioDao).save(argumentCaptor.capture());

    // then
    final Portfolio portfolio = argumentCaptor.getValue();
    Assert.assertThat(portfolioId, CoreMatchers.is(portfolio.getPortfolioId()));
    Assert.assertThat(1, CoreMatchers.is(portfolio.getStatus()));
    Assert.assertThat(1L, CoreMatchers.is(portfolio.getType()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void linkAccountFailedTest() {
    // when
    SignupData build = SignupData.builder().type("2").build();
    portfolioService.createPortfolio(build);
  }
}