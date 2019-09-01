package exemplo.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-09-01T09:55:12")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, Date> travelDate;
    public static volatile SingularAttribute<Request, Date> untilDate;
    public static volatile SingularAttribute<Request, Integer> id;
    public static volatile SingularAttribute<Request, String> justification;

}