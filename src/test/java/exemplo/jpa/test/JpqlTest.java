package exemplo.jpa.test;

import exemplo.jpa.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MASC
 */
public class JpqlTest extends GenericTest {

    @Test
    public void UserPorNome() {
        logger.info("Executando UserPorNome()");
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.name LIKE :name ORDER BY u.id",
                User.class);
        query.setParameter("name", "enilsu");
        List<User> users = query.getResultList();

        for (User user : users) {
            assertTrue(user.getName().startsWith("enilsu"));
        }

        assertEquals(1, users.size());
    }

    @Test
    public void AddressPorBairro() {
        logger.info("Executando AddressPorBairro()");
        TypedQuery<Address> query = em.createQuery(
                "SELECT ad FROM Address ad WHERE ad.neighborhood LIKE :neighborhood ORDER BY ad.id",
                Address.class);
        query.setParameter("neighborhood", "Zumbi");
        List<Address> addresss = query.getResultList();

        for (Address address : addresss) {
            assertTrue(address.getNeighborhood().startsWith("Zumbi"));
        }

        assertEquals(1, addresss.size());
    }
        
    @Test
    public void categoriaSQLNomeada() {
        logger.info("Executando sql()");
        Query query;
        query = em.createNamedQuery("user.porUsername");
        query.setParameter("username", "enilsinho");
        List<User> user = query.getResultList();
        assertEquals(1, user.size());
    }
    
    
 
}



