/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Bank_Details;
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
public class Bank_detailUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Bank_Details ad SET ad.account_Agency = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "Truewind");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Bank_Details ad WHERE ad.id = :id";
        TypedQuery<Bank_Details> query = em.createQuery(jpql, Bank_Details.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Bank_Details ad = query.getSingleResult();
        assertEquals("Truewind", ad.getAccount_Agency());
        logger.info(ad.getAccount_Agency().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Bank_Details AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Bank_Details ad WHERE ad.id =?1";
        TypedQuery<Bank_Details> query = em.createQuery(jpql, Bank_Details.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
