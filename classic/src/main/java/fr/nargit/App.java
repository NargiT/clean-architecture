package fr.nargit;

import fr.nargit.signup.Application;
import fr.nargit.signup.dao.LoginDao;
import fr.nargit.signup.dao.PersonDao;
import fr.nargit.signup.dao.PersonPortfolioDao;
import fr.nargit.signup.dao.PortfolioDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args )
    {
        System.out.println("Start classic application");
        new Application().start();
        System.out.println("Close classic application");
        System.exit(0);
    }
}
