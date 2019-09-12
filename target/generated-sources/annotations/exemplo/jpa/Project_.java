package exemplo.jpa;

import exemplo.jpa.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2019-09-12T18:07:32")
@StaticMetamodel(Project.class)
public abstract class Project_ { 

    public static volatile SingularAttribute<Project, Double> projectBudget;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, Integer> id;
    public static volatile SingularAttribute<Project, String> projectName;
    public static volatile ListAttribute<Project, User> users;

}