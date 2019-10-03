/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import exemplo.jpa.Agency;
import exemplo.jpa.Flight;
import exemplo.jpa.Hotel;
import exemplo.jpa.Itinerary;
import exemplo.jpa.Quote;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


public class HotelCrudTest extends GenericTest{
    
    @Test
    public void persistirHotel(){
        logger.info("Executando persistirHotel()");
        Hotel hotel = criarHotel();
         em.persist(hotel);
         em.flush();
         assertNotNull(hotel.getId());
        
    }
    
    @Test
    public void atualizarHotel() {

        logger.info("Atualizando Hotel");
        
        String newName = "HOTEL MARITIMO";
        Integer nStars = 3;
        
        
        Hotel hotel = em.find(Hotel.class, 1);
        hotel.setName(newName);
        hotel.setnStars(nStars);
        
        em.flush();
        em.clear();
        
        hotel = em.find(Hotel.class, 1);
        assertEquals(newName, hotel.getName());
        assertEquals(nStars, hotel.getnStars());
        

    }
   
    @Test
    public void atualizarHotelMerge() {
        
        logger.info("Atualizando Hotel com merge");
        String newName = "HOTEL terrestre";
        Integer nStars = 4;
        Hotel hotel = em.find(Hotel.class, 2);
            hotel.setName(newName);
        hotel.setnStars(nStars);
        em.clear();
        em.merge(hotel);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        hotel = em.find(Hotel.class, 2, properties);
        assertEquals(newName, hotel.getName());
        assertEquals(nStars, hotel.getnStars());

    }
    
    @Test
    public void atualizarAgencyJpqlTeste() {
        logger.info("Executando AtualizarAddress()");
        TypedQuery<Hotel> query = em.createNamedQuery("Hotel.porNome", Hotel.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("name","Plaza");
        Hotel hotel = query.getSingleResult();
        assertNotNull(hotel);
        hotel.setName("lalala");
        em.flush();
        assertEquals(0, query.getResultList().size());

    }
    
    @Test
    public void atualizarAddressMergeJpql() {
        logger.info("Executando atualizarAddressMerge()");
        TypedQuery<Hotel> query = em.createNamedQuery("Hotel.porNome", Hotel.class);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.setParameter("name", "holiday");
        Hotel hotel = query.getSingleResult();
        assertNotNull(hotel);
        hotel.setName("trtrtd");
        em.clear();        
        em.merge(hotel);
        em.flush();
       assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerCategoria() {
        logger.info("Executando removerCategoria()");
        TypedQuery<Hotel> query = em.createNamedQuery("Hotel.porNome", Hotel.class);
        query.setParameter("name", "trtrtd");
        Hotel hotel = query.getSingleResult();
        assertNotNull(hotel);
        em.remove(hotel);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
    
    
    
    
    @Test
    public void removerHotel(){
        logger.info("Executando removerHotel()");
        Hotel hotel = em.find(Hotel.class, 3);
        assertNotNull(hotel);
        em.remove(hotel);
        hotel = em.find(Hotel.class, 3);
        assertNull(hotel);
        
    }
    
    
    private Hotel criarHotel(){
        
        Hotel hotel = new Hotel();
        
        String nomeHotel = "Enseada dos corais";
        int nStars = 5;
        
        //endereco
        Address newAddress = new Address();
        newAddress.setStreet("Rua do mar");
        newAddress.setPostalCode("55534234");
        newAddress.setNumber(80);
        newAddress.setNeighborhood("Gaibu");
        newAddress.setState("Pernambuco");
        
        
        //quote
        
        Quote quote = new Quote();
        quote.setStatus("approved");
        quote.setIsSelected(0);
        Agency agency = em.find(Agency.class, 1);
        quote.setAgency(agency);
        Flight flight = em.find(Flight.class, 1);
        quote.setFlight(flight);
        Itinerary itinerary = em.find(Itinerary.class, 1);
        quote.setItinerary(itinerary);  
        quote.setHotel(hotel);
        
          
        List<Quote> quotes = new ArrayList<>();       
        quotes.add(quote);
          
        hotel.setName(nomeHotel);
        hotel.setnStars(nStars);
        hotel.setAddress(newAddress);
        hotel.setQuotes(quotes);
        
        
        return hotel;
        
    }
    
    
    
    
}
