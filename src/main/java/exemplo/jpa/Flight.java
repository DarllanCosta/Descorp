/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Darllan Costa
 */


@Entity
@Access(AccessType.FIELD)
public class Flight {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String provider;
    Integer number;
    String departure;
    String destination;
    Date checkin; 
    Date checkout;
    Double price;
    
}
