/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import exemplo.jpa.Bank_Details;
import exemplo.jpa.Project;
import exemplo.jpa.ProjectCliente;
import exemplo.jpa.Request;
import exemplo.jpa.User;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.CacheRetrieveMode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Guilherme Henrique
 */
public class UserCrudTest extends GenericTest {
    
    @Test
    public void persistirUser() {
        
        logger.info("Executando persistirUser()");
        User user = criarUser();
        em.persist(user);
        em.flush();
        assertNotNull(user.getId());
     
    }
    
    @Test
    public void atualizarUser() {

        logger.info("Atualizando user");
        String newName = "testando123";
        String newEmail = "Teste@Crud.com";
        String newPhone = "81 333333";
        
        User user = em.find(User.class, 1);
        user.setName(newName);
        user.setEmail(newEmail);
        user.setPhone(newPhone);
        
        
        em.flush();
        em.clear();
        
        user = em.find(User.class, 1);
        assertEquals(newName, user.getName());
        assertEquals(newEmail, user.getEmail());
        assertEquals(newPhone, user.getPhone());

    }
   
    @Test
    public void atualizarUserMerge() {
        
        logger.info("Atualizando User com merge");
        
        
        String newName = "te";
        String newEmail = "Teste@Cd.com";
        String newPhone = "81 4243131";
        
        User user = em.find(User.class, 2);
        user.setEmail(newEmail);
        user.setName(newName);
        user.setPhone(newPhone);
        em.clear();
        em.merge(user);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        user = em.find(User.class, 2, properties);
        assertEquals(newName, user.getName());
        assertEquals(newEmail, user.getEmail());
        assertEquals(newPhone, user.getPhone());
        

    }
       
    @Test
    public void removerUser() {
        logger.info("Executando removerFlight()");
        User user = em.find(User.class, 3);
        assertNotNull(user);
        em.remove(user);
        user = em.find(User.class, 3);
        assertNull(user);
    }
    
    private User criarUser(){
        User newUser = new User();
        newUser.setEmail("User@ifpe.com");
        newUser.setName("CrudTeste");
        newUser.setPassword("123453");
        newUser.setPhone("81 999548654");
        newUser.setUsername("TestandoOCrud");
        newUser.setAddress(criarAddress());
        newUser.setRequests(criarRequest());
        
        
        
        return newUser; 
    }
    
    
    private Address criarAddress(){
        Address ad = new Address();
        ad.setNeighborhood("Zumbi");
        ad.setNumber(854);
        ad.setPostalCode("8645413");
        ad.setState("Pernambuco");
        ad.setStreet("fidelis");
        
        return ad;
    }
    
    
    private List<Request> criarRequest(){
        
        List<Request> requests = new ArrayList<>();
        Calendar newDate = Calendar.getInstance();
        newDate.set(Calendar.YEAR,2020);
        newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
        newDate.set(Calendar.DAY_OF_MONTH, 5);
        Request request = new Request();
        request.setDeparture("Recife");
        request.setJustification("Teste");
        request.setTravelDate(newDate.getTime());
        request.setUntilDate(newDate.getTime());
        requests.add(request);
        return requests;
        
    }
        
        
        
    }
    
    
    

