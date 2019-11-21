package exemplo.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-11-21T16:23:09")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> number;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, String> neighborhood;
    public static volatile SingularAttribute<Address, String> state;

}