/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Quote;
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
public class QuoteUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Quote ad SET ad.Status = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "waitingManager");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Quote ad WHERE ad.id = :id";
        TypedQuery<Quote> query = em.createQuery(jpql, Quote.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Quote ad = query.getSingleResult();
        assertEquals("waitingManager", ad.getStatus());
        logger.info(ad.getStatus().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Quote AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Quote ad WHERE ad.id =?1";
        TypedQuery<Quote> query = em.createQuery(jpql, Quote.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
