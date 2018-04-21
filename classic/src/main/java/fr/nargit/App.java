package fr.nargit;

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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fr.nargit.domain");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManagerFactory.close();
        System.out.println("Close classic application");
    }
}
