/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Agency;
import exemplo.jpa.Flight;
import exemplo.jpa.Hotel;
import exemplo.jpa.Itinerary;
import exemplo.jpa.Quote;
import exemplo.jpa.User;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DarllanCosta
 */
public class ValidationTeste {
    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;
    
    
    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.OFF);
        emf = Persistence.createEntityManagerFactory("truetravel");
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    @After
    public void tearDown() {
        try {
            et.commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());

            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            em = null;
            et = null;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void PersistirQuoteInvalida(){
        try{
        Quote quote = new Quote();
               
        quote.setIsSelected(1);
        quote.setStatus("novo");
        em.persist(quote);
        }catch (ConstraintViolationException ex) {
            ConstraintViolation violation = ex.getConstraintViolations().iterator().next();
           assertEquals("O status especificado não existe", violation.getMessage());
           assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    
    
    }
    
    
    @Test
    public void PersistirQuoteValida(){
        Quote quote = new Quote();
               
        quote.setIsSelected(1);
        quote.setStatus("new");
        em.persist(quote);
        em.flush();
        assertNotNull(quote.getId());
               
    }  
    
    @Test(expected = ConstraintViolationException.class)
    public void persistirUsuarioInvalido() {
        User usuario = new User();
        
        try{
        
        usuario.setName("sadkjsakldjsakjdklsajdksajdklsajdsdsadnksadjklasjdklsajdklasjdklsajdklsadsadasjdklasjdksjadkljaskldjsakdjaskldjaskd");
        usuario.setEmail("oi"); // invalido
        usuario.setPassword("passwordqualquer");
        usuario.setUsername("qualquerusername");
        usuario.setPhone("8197771111");
        em.persist(usuario);
    
    }catch (ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        for (ConstraintViolation violation : constraintViolations) {
            assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                        startsWith("class exemplo.jpa.User.email: Não é um endereço de e-mail"),
                        startsWith("class exemplo.jpa.User.name: tamanho deve estar entre 0 e 50")
                        )
            );
        }
        
        assertEquals(2, constraintViolations.size());
            assertNull(usuario.getId());
            throw ex;
    }
}
    
    
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizarUsuarioInvalido() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name like :name", User.class);
        query.setParameter("name", "darllan");
        User usuario = query.getSingleResult();
        usuario.setEmail("a");

        try {
            em.flush();
        } catch (ConstraintViolationException ex) {           
            ConstraintViolation violation = ex.getConstraintViolations().iterator().next();
            assertEquals("Não é um endereço de e-mail", violation.getMessage());
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
    
    

}