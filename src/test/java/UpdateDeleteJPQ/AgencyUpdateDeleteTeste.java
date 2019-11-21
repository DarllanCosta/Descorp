/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Agency;
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
public class AgencyUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Agency ad SET ad.agencyName = ?1 WHERE ad.Id = ?2");
        update.setParameter(1, "Truewind");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Agency ad WHERE ad.Id = :id";
        TypedQuery<Agency> query = em.createQuery(jpql, Agency.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Agency ad = query.getSingleResult();
        assertEquals("Truewind", ad.getAgencyName());
        logger.info(ad.getAgencyName().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Agency AS ad WHERE ad.Id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Agency ad WHERE ad.Id =?1";
        TypedQuery<Agency> query = em.createQuery(jpql, Agency.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
