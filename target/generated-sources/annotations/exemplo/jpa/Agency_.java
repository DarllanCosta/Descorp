package exemplo.jpa;

import exemplo.jpa.Address;
import exemplo.jpa.Quote;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-10-03T18:20:07")
@StaticMetamodel(Agency.class)
public class Agency_ { 

    public static volatile SingularAttribute<Agency, Address> address;
    public static volatile SingularAttribute<Agency, String> phone;
    public static volatile SingularAttribute<Agency, Integer> Id;
    public static volatile SingularAttribute<Agency, String> agencyName;
    public static volatile SingularAttribute<Agency, String> email;
    public static volatile ListAttribute<Agency, Quote> quotes;

}