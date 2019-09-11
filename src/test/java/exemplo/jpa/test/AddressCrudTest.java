/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CacheRetrieveMode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Darllan Costa
 */
public class AddressCrudTest extends GenericTest {
    
    @Test
    public void persistirAddress() {
        
        logger.info("Executando persistirAddress()");
        Address address = criarAddress();
        em.persist(address);
        em.flush();
        assertNotNull(address.getId());
     
    }
    
    @Test
    public void atualizarAddress() {

        logger.info("Atualizando Address");
        
        String newStreet = "Rua das acacias";
        String newPostalCode = "54280080";
        String newState = "Paraiba";
        
        Address address = em.find(Address.class, 1);
        address.setStreet(newStreet);
        address.setPostalCode(newPostalCode);
        address.setState(newState);
        
        em.flush();
        em.clear();
        
         address = em.find(Address.class, 1);
        assertEquals(newStreet, address.getStreet());
        assertEquals(newPostalCode, address.getPostalCode());
        assertEquals(newState, address.getState());

    }
   
    @Test
    public void atualizarAddressMerge() {
        
        logger.info("Atualizando Address com merge");
        Integer newNumber = 55;
        String newNeighborhood = "Linha do Tiro";
        Address address = em.find(Address.class, 2);
        address.setNumber(newNumber);
        address.setNeighborhood(newNeighborhood);
        em.clear();
        em.merge(address);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        address = em.find(Address.class, 2, properties);
        assertEquals(newNumber, address.getNumber());
        assertEquals(newNeighborhood, address.getNeighborhood());

    }
       
    @Test
    public void removerAddress() {
        logger.info("Executando removerAddress()");
        Address address = em.find(Address.class, 9);
        assertNotNull(address);
        em.remove(address);
        address = em.find(Address.class, 9);
        assertNull(address);
    }
    
    private Address criarAddress(){
        Address newAddress = new Address();
        newAddress.setStreet("Rua da Lama");
        newAddress.setPostalCode("5428090");
        newAddress.setNumber(80);
        newAddress.setNeighborhood("Caxangá");
        newAddress.setState("Pernambuco");
        return newAddress;
     
        
    }
        
        
        
    }
    
    
    

