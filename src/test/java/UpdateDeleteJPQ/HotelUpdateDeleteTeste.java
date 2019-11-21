/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Hotel;
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
public class HotelUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Hotel ad SET ad.name = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "IF");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Hotel ad WHERE ad.id = :id";
        TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Hotel ad = query.getSingleResult();
        assertEquals("IF", ad.getName());
        logger.info(ad.getName().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Hotel AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Hotel ad WHERE ad.id =?1";
        TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
