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
public class QuoteCrudTest extends GenericTest {
    
    @Test
    public void persistirQuote() {
        
        logger.info("Executando persistirQuote()");
        Quote quote = criarQuote();
        em.persist(quote);
        em.flush();
        assertNotNull(quote.getId());
     
    }
    
    @Test
    public void atualizarQuote() {

        logger.info("Atualizando Flight");
        String NewStatus = "rejected";
        Agency newAgency = em.find(Agency.class, 1);
        
        
       Quote quote = em.find(Quote.class, 1);
        quote.setStatus(NewStatus);
        quote.setAgency(newAgency);
        
        
        em.flush();
        em.clear();
        
        newAgency = em.find(Agency.class, 1);
        assertEquals(NewStatus, quote.getStatus());
        assertEquals(newAgency, quote.getAgency());
     

    }
   
 /*   @Test
    public void atualizarQuoteMerge() {
        
        logger.info("Atualizando Flight com merge");
        
        Integer newSelected = 1;     
        Flight newFlight = em.find(Flight.class, 2);
        Hotel newHotel = em.find(Hotel.class, 2);
        
        Quote quote = em.find(Quote.class, 2);
       
        quote.setIsSelected(newSelected);
        quote.setFlight(newFlight);
        quote.setHotel(newHotel);

        
        em.clear();
        em.merge(quote);
        
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        quote = em.find(Quote.class, 2, properties);
        assertEquals(newFlight, quote.getFlight());
        assertEquals(newHotel, quote.getHotel());
        assertEquals(newSelected, quote.getIsSelected());
        

    }*/
       
    @Test
    public void removerQuote() {
        logger.info("Executando removerQuote()");
        Quote quote = em.find(Quote.class, 3);
        assertNotNull(quote);
        em.remove(quote);
        quote = em.find(Quote.class, 3);
        assertNull(quote);
    }
    
    private Quote criarQuote(){
        Quote quote = new Quote();
        
        
        Itinerary it = em.find(Itinerary.class, 2);
        quote.setItinerary(it);
        //Agency
        Agency agency = em.find(Agency.class, 1);
        quote.setAgency(agency);
        
        // Flight
        Flight flight = em.find(Flight.class, 1);;
        quote.setFlight(flight);
        
        Hotel hotel = em.find(Hotel.class, 1);
        quote.setHotel(hotel);
        
        quote.setIsSelected(1);
        
        quote.setStatus("new");
        
        return quote; 
    }
        
        
        
    }
    
    
    

