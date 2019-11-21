/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Flight;
import exemplo.jpa.test.GenericTest;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class FlightUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Flight ad SET ad.destination = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "IF");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Flight ad WHERE ad.id = :id";
        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Flight ad = query.getSingleResult();
        assertEquals("IF", ad.getDestination());
        logger.info(ad.getDestination().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Flight AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Flight ad WHERE ad.id =?1";
        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
