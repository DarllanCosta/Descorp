package exemplo.jpa;

import exemplo.jpa.Itinerary;
import exemplo.jpa.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-11-21T18:14:40")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile ListAttribute<Request, Itinerary> itinerarys;
    public static volatile SingularAttribute<Request, Date> travelDate;
    public static volatile SingularAttribute<Request, Date> untilDate;
    public static volatile SingularAttribute<Request, Integer> id;
    public static volatile SingularAttribute<Request, String> justification;
    public static volatile SingularAttribute<Request, String> departure;
    public static volatile SingularAttribute<Request, User> user;

}