/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.Address;
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
public class AddressUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE Address ad SET ad.street = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "Rua do IF");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM Address ad WHERE ad.id = :id";
        TypedQuery<Address> query = em.createQuery(jpql, Address.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Address ad = query.getSingleResult();
        assertEquals("Rua do IF", ad.getStreet());
        logger.info(ad.getStreet().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM Address AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 10);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM Address ad WHERE ad.id =?1";
        TypedQuery<Address> query = em.createQuery(jpql, Address.class);
        query.setParameter(1, 10);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
