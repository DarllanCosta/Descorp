/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import exemplo.jpa.Itinerary;
import exemplo.jpa.Request;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.Calendar;
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
public class IntineraryCrudTest extends GenericTest {
    
    @Test
    public void persistirItinerary() {
        
        logger.info("Executando persistirItinerary()");
        Itinerary itinerary = criarItinerary();
        em.persist(itinerary);
        em.flush();
        assertNotNull(itinerary.getId());
     
    }
    
    @Test
    public void atualizarItinerary() {

        logger.info("Atualizando Itinerary");
        
        String newDeparture = "Paraíba";
        String newDestination = "Pará";
        Request newRequest = em.find(Request.class, 2);
        
        Itinerary itinerary = em.find(Itinerary.class, 1);
        itinerary.setDeparture(newDeparture);
        itinerary.setDestination(newDestination);
        itinerary.setRequest(newRequest);
        
        em.flush();
        em.clear();
        
        itinerary = em.find(Itinerary.class, 1);
        assertEquals(newDeparture, itinerary.getDeparture());
        assertEquals(newDestination, itinerary.getDestination());
        assertEquals(newRequest, itinerary.getRequest());

    }
   
    @Test
    public void atualizarItineraryMerge() {
        
        logger.info("Atualizando Itinerary com merge");
        Itinerary itinerary = em.find(Itinerary.class, 2);
        
        Calendar newDate1 = Calendar.getInstance();
        newDate1.set(Calendar.YEAR,2020);
        newDate1.set(Calendar.MONTH, Calendar.JANUARY);
        newDate1.set(Calendar.DAY_OF_MONTH, 4);
        
        
       
        Calendar newDate2 = Calendar.getInstance();
        newDate2.set(Calendar.YEAR,2020);
        newDate2.set(Calendar.MONTH, Calendar.NOVEMBER);
        newDate2.set(Calendar.DAY_OF_MONTH, 15);
        
        itinerary.setCheckInDate(newDate1.getTime());
        itinerary.setCheckOutDate(newDate2.getTime());
                
        em.clear();        
        em.merge(itinerary);
        
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        itinerary = em.find(Itinerary.class, 2);
        assertEquals(newDate1.getTime(), itinerary.getCheckInDate());
        assertEquals(newDate2.getTime(), itinerary.getCheckOutDate());


    }
       
    @Test
    public void removerItinerary() {
        logger.info("Executando removerItinerary()");
        Itinerary itinerary = em.find(Itinerary.class, 3);
        assertNotNull(itinerary);
        em.remove(itinerary);
        itinerary = em.find(Itinerary.class, 3);
        assertNull(itinerary);
    }
    
    private Itinerary criarItinerary(){
       Itinerary itinerary = new Itinerary();
       itinerary.setDeparture("Alagoas");
       itinerary.setDestination("Rio Branco");
       Calendar newDate1 = Calendar.getInstance();
       newDate1.set(Calendar.YEAR,2019);
       newDate1.set(Calendar.MONTH, Calendar.DECEMBER);
       newDate1.set(Calendar.DAY_OF_MONTH, 15);
       
       Calendar newDate2 = Calendar.getInstance();
       newDate2.set(Calendar.YEAR,2020);
       newDate2.set(Calendar.MONTH, Calendar.JANUARY);
       newDate2.set(Calendar.DAY_OF_MONTH, 15);
       
       
       itinerary.setCheckInDate(newDate1.getTime());
       itinerary.setCheckOutDate(newDate2.getTime());
       
       
       //setRequest
       Request request = em.find(Request.class, 1);
       itinerary.setRequest(request);
       
       return itinerary;
                    
    }
        
        
        
    }
    
    
    

