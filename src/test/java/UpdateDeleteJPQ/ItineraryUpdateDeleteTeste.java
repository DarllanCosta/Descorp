/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Itinerary;
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
public class ItineraryUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Itinerary ad SET ad.departure = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "Fortaleza");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Itinerary ad WHERE ad.id = :id";
        TypedQuery<Itinerary> query = em.createQuery(jpql, Itinerary.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Itinerary ad = query.getSingleResult();
        assertEquals("Fortaleza", ad.getDeparture());
        logger.info(ad.getDeparture().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Itinerary AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Itinerary ad WHERE ad.id =?1";
        TypedQuery<Itinerary> query = em.createQuery(jpql, Itinerary.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
