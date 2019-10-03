package exemplo.jpa;

import exemplo.jpa.Quote;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-10-03T18:20:07")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, String> number;
    public static volatile SingularAttribute<Flight, Date> checkin;
    public static volatile SingularAttribute<Flight, String> provider;
    public static volatile SingularAttribute<Flight, Double> price;
    public static volatile SingularAttribute<Flight, String> destination;
    public static volatile SingularAttribute<Flight, Integer> id;
    public static volatile SingularAttribute<Flight, String> departure;
    public static volatile ListAttribute<Flight, Quote> quotes;

}