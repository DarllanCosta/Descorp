/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import exemplo.jpa.Agency;
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
public class AgencyCrudTest extends GenericTest {
    
    @Test
    public void persistirAgency() {
        
        logger.info("Executando persistirAddress()");
        Agency agency = criarAgency();
        em.persist(agency);
        em.flush();
        assertNotNull(agency.getId());
     
    }
    
    @Test
    public void atualizarAgency() {

        logger.info("Atualizando Address");
        
        String newName = "crudtestename";
        String newEmail = "TesteEmail@gmail.com";
        String newphone = "84866461";
        
        Agency agency = em.find(Agency.class, 1);
        agency.setAgencyName(newName);
        agency.setEmail(newEmail);
        agency.setPhone(newphone);
        
        em.flush();
        em.clear();
        
         agency = em.find(Agency.class, 1);
        assertEquals(newName, agency.getAgencyName());
        assertEquals(newEmail, agency.getEmail());
        assertEquals(newphone, agency.getPhone());

    }
   
    @Test
    public void atualizarAgencyMerge() {
        
        logger.info("Atualizando agency com merge");
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
    public void removerAgency() {
        logger.info("Executando removerAddress()");
        Agency agency = em.find(Agency.class, 3);
        assertNotNull(agency);
        em.remove(agency);
        agency = em.find(Agency.class, 3);
        assertNull(agency);
    }
    
    private Agency criarAgency(){
        Agency newAgency = new Agency();
        newAgency.setAgencyName("IFPE");
        newAgency.setEmail("if@gmail.com");
        newAgency.setPhone("84956");
        return newAgency;
     
        
    }
        
        
        
    }
    
    
    

