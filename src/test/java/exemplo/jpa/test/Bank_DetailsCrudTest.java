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
import javax.persistence.TypedQuery;
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
        String newNumber = "6765878765654454";
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
    public void atualizarAgencyJpqlTeste() {
        logger.info("Executando AtualizarAddress()");
        TypedQuery<Bank_Details> query = em.createNamedQuery("Bank.porNome", Bank_Details.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("account_Name", "Rodrigo");
        Bank_Details bank = query.getSingleResult();
        assertNotNull(bank);
        bank.setAccount_Name("Testando ojpql");
        em.flush();
        assertEquals(0, query.getResultList().size());

    }
    
    @Test
    public void atualizarAddressMergeJpql() {
        logger.info("Executando atualizarAddressMerge()");
        TypedQuery<Bank_Details> query = em.createNamedQuery("Bank.porNome", Bank_Details.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("account_Name", "Guilherme h f oliveira");
        Bank_Details bank = query.getSingleResult();
        assertNotNull(bank);
        bank.setAccount_Name("Testa");
        em.clear();        
        em.merge(bank);
        em.flush();
       assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerBankSQL() {
        logger.info("Executando removerCategoria()");
        TypedQuery<Bank_Details> query = em.createNamedQuery("Bank.porNome", Bank_Details.class);
        query.setParameter("account_Name", "Maia");
        Bank_Details bank = query.getSingleResult();
        assertNotNull(bank);
        em.remove(bank);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
       
    @Test
    public void removerBank() {
        logger.info("Executando removerBank()");
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
        bank.setAccount_Number("6062878787878787");
        bank.setAccount_Type("Corrente");
        
        return bank;
     
        
    }
        
        
        
    }
    
    
    

