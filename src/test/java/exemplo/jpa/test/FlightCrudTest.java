/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Flight;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;
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
public class FlightCrudTest extends GenericTest {
    
    @Test
    public void persistirFlight() {
        
        logger.info("Executando persistirAddress()");
        Flight flight = criarFlight();
        em.persist(flight);
        em.flush();
        assertNotNull(flight.getId());
     
    }
    
    @Test
    public void atualizarFlight() {

        logger.info("Atualizando Flight");
        String NewDeparture = "Bahia";
        String newDestination = "São Paulo";
        String newNumber = "v584854";
        Double newPrice = 4241.0;
        String newProvider = "JVAereo";
        
        Flight flight = em.find(Flight.class, 1);
        flight.setDeparture(NewDeparture);
        flight.setDestination(newDestination);
        flight.setNumber(newNumber);
        flight.setPrice(newPrice);
        flight.setProvider(newProvider);
        
        
        
        
        em.flush();
        em.clear();
        
         flight = em.find(Flight.class, 1);
        assertEquals(NewDeparture, flight.getDeparture());
        assertEquals(newDestination, flight.getDestination());
        assertEquals(newNumber, flight.getNumber());
        assertEquals(newProvider, flight.getProvider());
        assertEquals(newPrice, flight.getPrice());

    }
   
    
     @Test
    public void atualizarAgencyJpqlTeste() {
        logger.info("Executando AtualizarAddress()");
        TypedQuery<Flight> query = em.createNamedQuery("flight.porNumber", Flight.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("number", "T87");
        Flight flight = query.getSingleResult();
        assertNotNull(flight);
        flight.setNumber("t875");
        em.flush();
        assertEquals(0, query.getResultList().size());

    }
    
    @Test
    public void atualizarAddressMergeJpql() {
        logger.info("Executando atualizarAddressMerge()");
        TypedQuery<Flight> query = em.createNamedQuery("flight.porNumber", Flight.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("number", "T1885");
        Flight flight = query.getSingleResult();
        assertNotNull(flight);
        flight.setNumber("gg454");
        em.clear();        
        em.merge(flight);
        em.flush();
       assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerCategoria() {
        logger.info("Executando removerCategoria()");
        TypedQuery<Flight> query = em.createNamedQuery("flight.porNumber", Flight.class);
        query.setParameter("number", "T195655");
        Flight flight = query.getSingleResult();
        assertNotNull(flight);
        em.remove(flight);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
       
    @Test
    public void removerFlight() {
        logger.info("Executando removerFlight()");
        Flight flight = em.find(Flight.class, 3);
        assertNotNull(flight);
        em.remove(flight);
        flight = em.find(Flight.class, 3);
        assertNull(flight);
    }
    
    private Flight criarFlight(){
        Flight newFlight = new Flight();
        Calendar newDate = Calendar.getInstance();
        newDate.set(Calendar.YEAR,2020);
        newDate.set(Calendar.MONTH, Calendar.NOVEMBER);
        newDate.set(Calendar.DAY_OF_MONTH, 5);
        newFlight.setProvider("IFPETRAVEL");
        newFlight.setCheckin(newDate.getTime());
        newFlight.setDeparture("Recife");
        newFlight.setDestination("Fortaleza");
        newFlight.setNumber("T8945");
        newFlight.setPrice(954.0);
        return newFlight; 
    }
        
        
        
    }
    
    
    

