/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateDeleteJPQ;



import exemplo.jpa.ProjectCliente;
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
public class ProjectClienteUpdateDeleteTeste extends GenericTest {

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Query update = em.createQuery("UPDATE ProjectCliente ad SET ad.clientName = ?1 WHERE ad.id = ?2");
        update.setParameter(1, "Anakin");
        update.setParameter(2, 1);
        update.executeUpdate();
        String jpql = "SELECT ad FROM ProjectCliente ad WHERE ad.id = :id";
        TypedQuery<ProjectCliente> query = em.createQuery(jpql, ProjectCliente.class);
        query.setParameter("id", 1);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        ProjectCliente ad = query.getSingleResult();
        assertEquals("Anakin", ad.getClientName());
        logger.info(ad.getClientName().toString());
    }

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Query delete = em.createQuery("DELETE FROM ProjectCliente AS ad WHERE ad.id = ?1");
        delete.setParameter(1, 5);
        delete.executeUpdate();
        String jpql = "SELECT ad FROM ProjectCliente ad WHERE ad.id =?1";
        TypedQuery<ProjectCliente> query = em.createQuery(jpql, ProjectCliente.class);
        query.setParameter(1, 5);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
}
