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
    public void atualizarFlightMerge() {
        
        logger.info("Atualizando Flight com merge");
        
        Calendar newDate = Calendar.getInstance();
        newDate.set(Calendar.YEAR,2019);
        newDate.set(Calendar.MONTH, Calendar.DECEMBER);
        newDate.set(Calendar.DAY_OF_MONTH, 12);
        String NewDeparture = "mato grosso";
        String newDestination = "rio de janeiro";
        String newNumber = "r595";
        Double newPrice = 5441.0;
        String newProvider = "darllanTravel";
        
        Flight flight = em.find(Flight.class, 2);
        flight.setCheckin(newDate.getTime());
        flight.setDeparture(NewDeparture);
        flight.setDestination(newDestination);
        flight.setNumber(newNumber);
        flight.setPrice(newPrice);
        flight.setProvider(newProvider);
        em.clear();
        em.merge(flight);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        flight = em.find(Flight.class, 2, properties);
        assertEquals(newDate.getTime(), flight.getCheckin());
        assertEquals(NewDeparture, flight.getDeparture());
        assertEquals(newDestination, flight.getDestination());
        assertEquals(newNumber, flight.getNumber());
        assertEquals(newProvider, flight.getProvider());
        assertEquals(newPrice, flight.getPrice());

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
        newDate.set(Calendar.YEAR,2019);
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
    
    
    

