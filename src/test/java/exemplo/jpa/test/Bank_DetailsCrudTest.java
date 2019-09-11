/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Bank_Details;
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
public class Bank_DetailsCrudTest extends GenericTest {
    
    @Test
    public void persistirBank_Details() {
        
        logger.info("Executando persistirAddress()");
        Bank_Details bank = criarBank();
        em.persist(bank);
        em.flush();
        assertNotNull(bank.getId());
     
    }
    
    @Test
    public void atualizarBank() {

        logger.info("Atualizando Bank_Detail");
        
        String newname = "joao";
        String newNumber = "54280080";
        String newAgency = "Paraiba";
        
        Bank_Details bank = em.find(Bank_Details.class, 1);
        bank.setAccount_Agency(newAgency);
        bank.setAccount_Name(newname);
        bank.setAccount_Number(newNumber);
        em.flush();
        em.clear();
        
         bank = em.find(Bank_Details.class, 1);
        assertEquals(newname, bank.getAccount_Name());
        assertEquals(newNumber, bank.getAccount_Number());
        assertEquals(newAgency, bank.getAccount_Agency());

    }
   
    @Test
    public void atualizarBankMerge() {
        
        logger.info("Atualizando Bank com merge");
        String newName = "Ricardo";
        String newAgency = "Santander";
        Bank_Details bank = em.find(Bank_Details.class, 2);
        bank.setAccount_Agency(newAgency);
        bank.setAccount_Name(newName);
        em.clear();
        em.merge(bank);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        bank = em.find(Bank_Details.class, 2, properties);
        assertEquals(newAgency, bank.getAccount_Agency());
        assertEquals(newName, bank.getAccount_Name());

    }
       
    @Test
    public void removerAddress() {
        logger.info("Executando removerAddress()");
        Bank_Details bank = em.find(Bank_Details.class, 3);
        assertNotNull(bank);
        em.remove(bank);
        bank = em.find(Bank_Details.class, 3);
        assertNull(bank);
    }
    
    private Bank_Details criarBank(){
        Bank_Details bank = new Bank_Details();
        bank.setAccount_Agency("Bradesco");
        bank.setAccount_Name("Darllan");
        bank.setAccount_Number("251245412");
        bank.setAccount_Type("Corrente");
        return bank;
     
        
    }
        
        
        
    }
    
    
    

