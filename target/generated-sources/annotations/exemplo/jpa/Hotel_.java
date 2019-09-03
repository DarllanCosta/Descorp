package exemplo.jpa;

import exemplo.jpa.Address;
import exemplo.jpa.Quote;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-09-03T19:50:27")
@StaticMetamodel(Hotel.class)
public class Hotel_ { 

    public static volatile SingularAttribute<Hotel, Address> address;
    public static volatile SingularAttribute<Hotel, String> name;
    public static volatile SingularAttribute<Hotel, Integer> id;
    public static volatile SingularAttribute<Hotel, Integer> nStars;
    public static volatile ListAttribute<Hotel, Quote> quotes;

}