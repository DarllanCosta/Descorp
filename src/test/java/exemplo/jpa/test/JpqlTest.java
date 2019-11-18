package exemplo.jpa.test;

import exemplo.jpa.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MASC
 */
public class JpqlTest extends GenericTest {

    @Test
    public void UserPorNome() {
        logger.info("Executando UserPorNome()");
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.name LIKE :name ORDER BY u.id",
                User.class);
        query.setParameter("name", "enilsu");
        List<User> users = query.getResultList();

        for (User user : users) {
            assertTrue(user.getName().startsWith("enilsu"));
        }

        assertEquals(1, users.size());
    }

    @Test
    public void AddressPorBairro() {
        logger.info("Executando AddressPorBairro()");
        TypedQuery<Address> query = em.createQuery(
                "SELECT ad FROM Address ad WHERE ad.neighborhood LIKE :neighborhood ORDER BY ad.id",
                Address.class);
        query.setParameter("neighborhood", "Zumbi");
        List<Address> addresss = query.getResultList();

        for (Address address : addresss) {
            assertTrue(address.getNeighborhood().startsWith("Zumbi"));
        }

        assertEquals(1, addresss.size());
    }
        
    @Test
    public void categoriaSQLNomeada() {
        logger.info("Executando sql()");
        Query query;
        query = em.createNamedQuery("user.porUsername");
        query.setParameter("username", "enilsinho");
        List<User> user = query.getResultList();
        assertEquals(1, user.size());
    }
    
    @Test
    public void AddressPorEstado(){
        logger.info("Executando Adress por Estado");
        Query query;
        query = em.createNamedQuery("user.porEstado");
        query.setParameter("state","Pernambuco");
        List<Address> address = query.getResultList();

        for (Address ad : address) {
            assertTrue(ad.getState().startsWith("Pernambuco"));
        }

        assertEquals(13, address.size());
    }
    @Test
    public void AgencyPorEmail(){
        logger.info("Executando Agency por Email");
        Query query;
        query = em.createNamedQuery("Agency.porEmail");
        query.setParameter("email","cvc@descorp.com");
        List<Agency> agency = query.getResultList();

        for (Agency ad : agency) {
            assertTrue(ad.getEmail().startsWith("cvc@descorp.com"));
        }

        assertEquals(1, agency.size());
    }
    @Test
    public void AgencyPorTelefone(){
        logger.info("Executando Agency por telefone");
        Query query;
        query = em.createNamedQuery("Agency.porTelefone");
        query.setParameter("phone","819995784");
        List<Agency> agency = query.getResultList();

        for (Agency ad : agency) {
            assertTrue(ad.getPhone().startsWith("819995784"));
        }

        assertEquals(1, agency.size());
    }
    @Test
    public void bankPorAgencia(){
        logger.info("Executando Bank por agencia");
        Query query;
        query = em.createNamedQuery("Bank.porAgencia");
        query.setParameter("account_Agency","bradesco");
        List<Bank_Details> bank = query.getResultList();

        for (Bank_Details ad : bank) {
            assertTrue(ad.getAccount_Agency().startsWith("bradesco"));
        }

        assertEquals(2, bank.size());
    }
    @Test
    public void BankPorTipo(){
        logger.info("Executando Bank por agencia");
        Query query;
        query = em.createNamedQuery("Bank.porTipo");
        query.setParameter("account_Type","Corrente");
        List<Bank_Details> bank = query.getResultList();

        for (Bank_Details ad : bank) {
            assertTrue(ad.getAccount_Type().startsWith("Corrente"));
        }

        assertEquals(4, bank.size());
    }
    @Test
    public void BankPorNome(){
        logger.info("Executando Bank por Nome");
        Query query;
        query = em.createNamedQuery("Bank.porNome");
        query.setParameter("account_Name","Darllan Enilson");
        List<Bank_Details> bank = query.getResultList();

        for (Bank_Details ad : bank) {
            assertTrue(ad.getAccount_Name().startsWith("Darllan Enilson"));
        }

        assertEquals(1, bank.size());
    }
    @Test
    public void FloghtProNumber(){
        logger.info("Executando Flight por Numero");
        Query query;
        query = em.createNamedQuery("flight.porNumber");
        query.setParameter("number","T195655");
        List<Flight> flight = query.getResultList();

        for (Flight fl : flight) {
            assertTrue(fl.getNumber().startsWith("T195655"));
        }

        assertEquals(1, flight.size());
    }
    @Test
    public void HotelPorNumeroDeEstrelar(){
        logger.info("Executando hotel por Estrelas");
        Query query;
        query = em.createNamedQuery("Hotel.porNumeroDeEstrelas");
        query.setParameter("nStars",5);
        List<Hotel> hotel = query.getResultList();

        for (Hotel ho : hotel) {
            assertEquals(new Integer(5) ,ho.getnStars());
        }

        assertEquals(5, hotel.size());
    }
    @Test
    public void InternalProjectProDepartamento(){
        logger.info("Executando project por departamento");
        Query query;
        query = em.createNamedQuery("InternalProject.porDepartamento");
        query.setParameter("department", "ti");
        List<InternalProject> project = query.getResultList();

        for (InternalProject po : project) {
                 assertTrue(po.getDepartment().startsWith("ti"));
        }

        assertEquals(1, project.size());
    }
    
    @Test
    public void ItineraryPorDeparture(){
        logger.info("Executando Itinerary por departure");
        Query query;
        query = em.createNamedQuery("itineraryPorDeparture");
        query.setParameter("departure", "Recife");
        List<Itinerary> itinerary = query.getResultList();

        for (Itinerary it : itinerary) {
                 assertTrue(it.getDeparture().startsWith("Recife"));
        }

        assertEquals(4, itinerary.size());
    }
    @Test
    public void ProjectClientPorAllocation(){
        logger.info("Executando project por Allocation");
        Query query;
        query = em.createNamedQuery("ProjectCliente.porAllocation");
        query.setParameter("allocation", true);
        List<ProjectCliente> project = query.getResultList();

        for (ProjectCliente po : project) {
                 assertTrue(po.getAllocation().booleanValue());
        }

        assertEquals(2, project.size());
    }
    @Test
    public void ProjectClientPorNome(){
        logger.info("Executando project por Allocation");
        Query query;
        query = em.createNamedQuery("ProjectCliente.porNome");
        query.setParameter("clientName", "travler");
        List<ProjectCliente> project = query.getResultList();

        for (ProjectCliente po : project) {
                 assertTrue(po.getProjectName().startsWith("travler"));
        }

        assertEquals(0, project.size());
    }
    @Test
    public void QuotePorStatus(){
        logger.info("Executando Quote por Status");
        Query query;
        query = em.createNamedQuery("quote.porStatus");
        query.setParameter("Status", "new");
        List<Quote> quote = query.getResultList();

        for (Quote po : quote) {
                 assertTrue(po.getStatus().startsWith("new"));
        }

        assertEquals(4, quote.size());
    }
    @Test
    public void RequestPorDeparture(){
        logger.info("Executando Quote por Status");
        Query query;
        query = em.createNamedQuery("request.porDeparture");
        query.setParameter("departure", "Recife");
        List<Request> request = query.getResultList();

        for (Request po : request) {
                 assertTrue(po.getDeparture().startsWith("Recife"));
        }

        assertEquals(4, request.size());
    }
    @Test
    public void UserPorUsername(){
        logger.info("Executando Quote por Status");
        Query query;
        query = em.createNamedQuery("user.porUsername");
        query.setParameter("username", "darllanzinho");
        List<User> user = query.getResultList();

        for (User po : user) {
                 assertTrue(po.getUsername().startsWith("darllanzinho"));
        }

        assertEquals(1, user.size());
    }
    
    @Test
    public void QuantidadeAddressPorCEP(){
        logger.info("Executando QuantidadeAddressPorCep()");
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Hotel a WHERE a.address IS NOT NULL", Long.class);
        
        Long resultado = query.getSingleResult();
        assertEquals(new Long(7), resultado);  
    }
    
    @Test
    public void QuoteFlightsDeparture(){
        logger.info("Executando QuoteFlightsDeparture()");
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Quote a WHERE a.flight.departure LIKE :departure", Long.class);
        query.setParameter("departure", "Recife");
        
        Long resultado = query.getSingleResult();
        assertEquals(new Long(4), resultado);  
    }
    
    @Test
    public void userAddress(){
        logger.info("Executando userAddress()");
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM User a WHERE a.address.postalCode LIKE :cep", Long.class);
        query.setParameter("cep", "50720660");
        
        Long resultado = query.getSingleResult();
        assertEquals(new Long(0), resultado);  
    }
    @Test
    public void HotelPorAddress(){
        logger.info("Executando HotelPorAddress()");
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Hotel a WHERE a.address.state LIKE :state", Long.class);
        query.setParameter("state", "Pernambuco");
        
        Long resultado = query.getSingleResult();
        assertEquals(new Long(5), resultado);  
    }
    @Test
    public void FlightPorDestination(){
        logger.info("Executando FligtPorDestination()");
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Flight a WHERE a.destination LIKE :destination", Long.class);
        query.setParameter("destination", "Bahia");
        
        Long resultado = query.getSingleResult();
        assertEquals(new Long(4), resultado);  
    }
    
    @Test
    public void FlightPrice() {
        logger.info("Executando FlightPrice()");
        TypedQuery<Flight> query;
        query = em.createQuery(
                "SELECT a FROM Flight a WHERE a.price BETWEEN ?1 AND ?2",
                Flight.class);
        query.setParameter(1, 1000);
        query.setParameter(2, 2000);
        List<Flight> flight = query.getResultList();
        assertEquals(1, flight.size());
    }
    @Test
    public void hotelStars() {
        logger.info("Executando hotelstars()");
        TypedQuery<Hotel> query;
        query = em.createQuery(
                "SELECT a FROM Hotel a WHERE a.nStars BETWEEN ?1 AND ?2",
                Hotel.class);
        query.setParameter(1, 3);
        query.setParameter(2, 5);
        List<Hotel> hotel = query.getResultList();
        assertEquals(6, hotel.size());
    }
    
    @Test
    public void quoteFlightDeparture() {
        logger.info("Executando QuoteFlightDeparture()");
        TypedQuery<Quote> query;
        query = em.createQuery(
                "SELECT c FROM Quote c "
                + "WHERE c.flight.departure LIKE ?1 "
                + "OR c.flight.departure LIKE ?2",
                Quote.class);
        query.setParameter(1, "Recife"); 
        query.setParameter(2, "Bahia");        
        List<Quote> quotes = query.getResultList();

        for (Quote q : quotes) {
            assertThat(q.getFlight().getDeparture(),
                    CoreMatchers.anyOf(startsWith("Recife"), startsWith("Bahia")));
        }

        assertEquals(4, quotes.size());
    }
    @Test
    public void QuoteHotelAddressState() {
        logger.info("Executando QuoteAddressHotelState()");
        TypedQuery<Quote> query;
        query = em.createQuery(
                "SELECT c FROM Quote c "
                + "WHERE c.hotel.address.state LIKE ?1 "
                + "OR c.hotel.address.state LIKE ?2",
                Quote.class);
        query.setParameter(1, "Pernambuco"); 
        query.setParameter(2, "Fortaleza");        
        List<Quote> quotes = query.getResultList();

        for (Quote q : quotes) {
            assertThat(q.getHotel().getAddress().getState(),
                    CoreMatchers.anyOf(startsWith("Pernambuco"), startsWith("Fortaleza")));
        }

        assertEquals(4, quotes.size());
    }
    @Test
    public void QuoteHotelAddressNeighbourhood() {
        logger.info("Executando QuoteAddressHotelState()");
        TypedQuery<Quote> query;
        query = em.createQuery(
                "SELECT c FROM Quote c "
                + "WHERE c.hotel.address.neighborhood LIKE ?1 "
                + "OR c.hotel.address.neighborhood LIKE ?2",
                Quote.class);
        query.setParameter(1, "Zumbi"); 
        query.setParameter(2, "Boa Vista");        
        List<Quote> quotes = query.getResultList();

        for (Quote q : quotes) {
            assertThat(q.getHotel().getAddress().getNeighborhood(),
                    CoreMatchers.anyOf(startsWith("Zumbi"), startsWith("Boa Vista")));
        }

        assertEquals(1, quotes.size());
    }
    
    @Test
    public void usernamesDistintos() {
        logger.info("Executando usernamesDistintos()");
        TypedQuery<String> query
                = em.createQuery("SELECT DISTINCT(c.username) FROM User c ORDER BY c.username", String.class);
        List<String> username = query.getResultList();
        assertEquals(5, username.size());
    }
    @Test
    public void departureDistinct() {
        logger.info("Executando departureDistinct()");
        TypedQuery<String> query
                = em.createQuery("SELECT DISTINCT(c.departure) FROM Request c ORDER BY c.departure", String.class);
        List<String> dep = query.getResultList();
        assertEquals(1, dep.size());
    }
    @Test
    public void ordenacaoCartao() {
        logger.info("Executando ordenacaoCartao()");
        TypedQuery<Bank_Details> query;
        query = em.createQuery(
                "SELECT c FROM Bank_Details c ORDER BY c.account_Number DESC",
                Bank_Details.class);
        List<Bank_Details> cartoes = query.getResultList();
        assertEquals(6, cartoes.size());
        assertEquals("6062878787878787", cartoes.get(0).getAccount_Number());
        assertEquals("6062878787878787", cartoes.get(1).getAccount_Number());
        assertEquals("6062878787878787", cartoes.get(2).getAccount_Number());
        assertEquals("6062878787878787", cartoes.get(3).getAccount_Number());
        assertEquals("60628787878787", cartoes.get(4).getAccount_Number());
        assertEquals("606287878787823787", cartoes.get(5).getAccount_Number());
       
    }
    
    @Test
    public void BankTypes() {
        logger.info("Executando BankTypes()");
        TypedQuery<Bank_Details> query;
        query = em.createQuery(
                "SELECT c FROM Bank_Details c "
                + "WHERE c.account_Type IN ('Corrente', 'poupança')",
                Bank_Details.class);
        List<Bank_Details> bank = query.getResultList();

        for (Bank_Details b : bank) {
            assertThat(b.getAccount_Type(),
                    CoreMatchers.anyOf(
                            startsWith("Corrente"),
                            startsWith("poupança")));
        }

        assertEquals(5, bank.size());
    }
    
    @Test
    public void AgencyDistinct() {
        logger.info("Executando departureDistinct()");
        TypedQuery<String> query
                = em.createQuery("SELECT DISTINCT(c.account_Name) FROM Bank_Details c ORDER BY c.account_Name", String.class);
        List<String> dep = query.getResultList();
        assertEquals(6, dep.size());
    }
    
    
   
    
 
}



