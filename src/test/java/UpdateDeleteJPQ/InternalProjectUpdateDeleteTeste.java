/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.InternalProject;
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
public class InternalProjectUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE InternalProject ad SET ad.description = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "Testando o Update");
        update.setParameter(2, 3);
        update.executeUpdate();
        String jpql = "SELECT ad FROM InternalProject ad WHERE ad.id = :id";
        TypedQuery<InternalProject> query = em.createQuery(jpql, InternalProject.class);
        query.setParameter("id", 3);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        InternalProject ad = query.getSingleResult();
        assertEquals("Testando o Update", ad.getDescription());
        logger.info(ad.getDescription().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM InternalProject AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 4);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM InternalProject ad WHERE ad.id =?1";
        TypedQuery<InternalProject> query = em.createQuery(jpql, InternalProject.class);
        query.setParameter(1, 4);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
