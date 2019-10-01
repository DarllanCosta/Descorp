package exemplo.jpa;

import exemplo.jpa.Agency;
import exemplo.jpa.Flight;
import exemplo.jpa.Hotel;
import exemplo.jpa.Itinerary;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-09-30T20:26:12")
@StaticMetamodel(Quote.class)
public class Quote_ { 

    public static volatile SingularAttribute<Quote, String> Status;
    public static volatile SingularAttribute<Quote, Flight> flight;
    public static volatile SingularAttribute<Quote, Agency> agency;
    public static volatile SingularAttribute<Quote, Integer> isSelected;
    public static volatile SingularAttribute<Quote, Hotel> hotel;
    public static volatile SingularAttribute<Quote, Itinerary> itinerary;
    public static volatile SingularAttribute<Quote, Integer> id;

}