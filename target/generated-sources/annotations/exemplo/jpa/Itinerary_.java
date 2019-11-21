package exemplo.jpa;

import exemplo.jpa.Quote;
import exemplo.jpa.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-11-21T18:14:40")
@StaticMetamodel(Itinerary.class)
public class Itinerary_ { 

    public static volatile SingularAttribute<Itinerary, Request> request;
    public static volatile SingularAttribute<Itinerary, Date> checkOutDate;
    public static volatile SingularAttribute<Itinerary, String> destination;
    public static volatile SingularAttribute<Itinerary, Integer> id;
    public static volatile SingularAttribute<Itinerary, String> departure;
    public static volatile SingularAttribute<Itinerary, Date> checkInDate;
    public static volatile ListAttribute<Itinerary, Quote> quotes;

}