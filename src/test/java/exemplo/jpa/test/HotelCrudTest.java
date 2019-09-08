/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.Address;
import exemplo.jpa.Hotel;
import exemplo.jpa.Quote;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
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
        quote.setIsSelected(0);
        quote.setStatus("Aguardando Aprovação");
        
        Quote quote2 = new Quote();
        quote.setIsSelected(1);
        quote.setStatus("Aguardando Aprovação");  
        List<Quote> quotes = new ArrayList<>();       
        quotes.add(quote);
        quotes.add(quote2);
        
        
        
        hotel.setName(nomeHotel);
        hotel.setnStars(nStars);
        hotel.setAddress(newAddress);
        hotel.setQuotes(quotes);
        
        
        return hotel;
        
    }
    
    
    
    
}
