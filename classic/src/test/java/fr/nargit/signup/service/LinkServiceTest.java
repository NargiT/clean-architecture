package fr.nargit.signup.service;

import fr.nargit.signup.dao.PortfolioDao;
import fr.nargit.signup.domain.Portfolio;
import fr.nargit.signup.service.dto.SignupData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * (c) Swissquote 24-avr.-2018
 *
 * @author Tigran
 */
@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class LinkServiceTest {

	@Mock
	private PortfolioDao portfolioDao;

	@InjectMocks
	private PortfolioService portfolioService;

	@Test
	public void linkAccountSuccessTest() {
		Mockito.when(portfolioDao.find(Mockito.any(Object.class))).thenReturn(Portfolio.builder()
				.type(1L)
				.build());
		// when
		SignupData trading = SignupData.builder()
				.type("TRADING")
				.build();
		portfolioService.createPortfolio(trading);
	}

	@Test(expected = IllegalArgumentException.class)
	public void linkAccountFailedTest() {
		// when
		SignupData build = SignupData.builder().build();
		portfolioService.createPortfolio(build);
	}
}