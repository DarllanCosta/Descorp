package exemplo.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-09-01T09:55:12")
@StaticMetamodel(Itinerary.class)
public class Itinerary_ { 

    public static volatile SingularAttribute<Itinerary, Date> checkOutDate;
    public static volatile SingularAttribute<Itinerary, String> destination;
    public static volatile SingularAttribute<Itinerary, Integer> id;
    public static volatile SingularAttribute<Itinerary, String> departure;
    public static volatile SingularAttribute<Itinerary, Date> checkInDate;

}