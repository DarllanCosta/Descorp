/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Itinerary;
import exemplo.jpa.Request;
import exemplo.jpa.User;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
public class RequestCrudTest extends GenericTest {
    
    @Test
    public void persistirRequest() {
        
        logger.info("Executando persistirAddress()");
        Request request = criarRequest();
        em.persist(request);
        em.flush();
        assertNotNull(request.getId());       
    }
    
    @Test
    public void atualizarRequest() {

        logger.info("Atualizando Request");
        
        String newJustification = "Conhecer nova filial";
        String newDeparture = "Jaboatao";
        
        Request request = em.find(Request.class, 2);
        request.setDeparture(newDeparture);
        request.setJustification(newJustification);
        
        em.flush();
        em.clear();
        
        request = em.find(Request.class, 2);
        assertEquals(newDeparture, request.getDeparture());
        assertEquals(newJustification, request.getJustification());
       

    }
   
    @Test
    public void atualizarRequestComMerge() {
        
        logger.info("Atualizando Request com merge");
        
        Calendar newDate = Calendar.getInstance();
        newDate.set(Calendar.YEAR,2020);
        newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
        newDate.set(Calendar.DAY_OF_MONTH, 8);
        
        String newJustification = "passeio";
        
        Request request = em.find(Request.class, 3);
        request.setJustification(newJustification);
        request.setTravelDate(newDate.getTime());
        em.clear();
        em.merge(request);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        request = em.find(Request.class, 3);
        assertEquals(newJustification, request.getJustification());
        assertEquals(newDate.getTime(), request.getTravelDate());

    }
       
    @Test
    public void removerRequest() {
        logger.info("Executando removerAddress()");
        Request request = em.find(Request.class, 4);
        assertNotNull(request);
        em.remove(request);
        request = em.find(Request.class, 4);
        assertNull(request);
    }
    
    private Request criarRequest(){
       Request request = new Request();
       
       request.setJustification("Viagem necessária para fechar negócios com o cliente");
       
       request.setDeparture("Recife");
       
       Calendar newDate = Calendar.getInstance();
       newDate.set(Calendar.YEAR,2020);
       newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
       newDate.set(Calendar.DAY_OF_MONTH, 8);
       request.setTravelDate(newDate.getTime());
       
       
       newDate.set(Calendar.YEAR,2020);
       newDate.set(Calendar.MONTH, Calendar.NOVEMBER);
       newDate.set(Calendar.DAY_OF_MONTH, 8);
       request.setUntilDate(newDate.getTime());
      
       //adicionar Usuario
       request.setUser(em.find(User.class, 1));
  
       //adicionar itineraries
       List<Itinerary> itineraries = new ArrayList<>();
       Itinerary itinerary1 = new Itinerary();
          itinerary1.setDeparture("Recife");
          itinerary1.setDestination("São Paulo");
          itinerary1.setRequest(request);
          
          newDate.set(Calendar.YEAR,2020);
          newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
          newDate.set(Calendar.DAY_OF_MONTH, 8);
          
          itinerary1.setCheckInDate(newDate.getTime());
          
          newDate.set(Calendar.YEAR,2020);
          newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
          newDate.set(Calendar.DAY_OF_MONTH, 25);
          
          itinerary1.setCheckOutDate(newDate.getTime());
          
          Itinerary itinerary2 = new Itinerary();
          itinerary2.setDeparture("São Paulo");
          itinerary2.setDestination("Alagoas");
          itinerary2.setRequest(request);
          
          newDate.set(Calendar.YEAR,2020);
          newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
          newDate.set(Calendar.DAY_OF_MONTH, 25);
          itinerary2.setCheckInDate(newDate.getTime());
          
         
          newDate.set(Calendar.YEAR,2020);
          newDate.set(Calendar.MONTH, Calendar.NOVEMBER);
          newDate.set(Calendar.DAY_OF_MONTH, 25);
          
          itinerary2.setCheckOutDate(newDate.getTime());
        
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
    
       
       return request;
        
    }
        
        
        
    }
    
    
    

