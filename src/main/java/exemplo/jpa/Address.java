/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Darllan Costa
 */


@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Address.porBairro",
                    query = "SELECT ad FROM Address ad WHERE ad.neighborhood LIKE :neighborhood ORDER BY ad.id"
            ),
            @NamedQuery(
                    name = "user.porEstado",
                    query = "SELECT ad FROM Address ad WHERE ad.state LIKE :state ORDER BY ad.id"
            )
        }
)
@Access(AccessType.FIELD)
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "TXT_STREET", nullable = false, length = 255)
    @NotNull
    String street;
    @Column(name = "POSTAL_CODE", nullable = false, length = 20)
    @NotNull
    String postalCode;
    @Column(name = "TXT_NEIGHBORHOOD",   nullable = false, length = 20)
    @NotNull
    String neighborhood;
    @Column(name = "TXT_STATE", nullable = false, length = 255)
    @NotNull
    String state;
    @Column(name = "NUMBER", nullable = false)
    @NotNull
    @DecimalMin(value = "0")
    Integer number;

    public Address() {
    }

    public Integer getId() {
        return id;
    }
    
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

    
}
