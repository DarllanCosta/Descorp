package exemplo.jpa;

import exemplo.jpa.Address;
import exemplo.jpa.Bank_Details;
import exemplo.jpa.Project;
import exemplo.jpa.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-11-21T01:26:39")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Address> address;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Project> projetos;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, Request> requests;
    public static volatile SingularAttribute<User, Bank_Details> bank_Details;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}