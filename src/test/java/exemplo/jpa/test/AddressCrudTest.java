/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import static exemplo.jpa.test.GenericTest.logger;
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
    
    
    

