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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Darllan Costa
 */

@NamedQueries(
        {
            @NamedQuery(
                    name = "quote.porStatus",
                    query = "SELECT q FROM Quote q WHERE q.Status LIKE :Status ORDER BY q.id"
            )
                
        }
)
@Entity
@Access(AccessType.FIELD)
public class Quote implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
   // @NotNull
    @Column(name = "IS_SELECTED", nullable = false)
    Integer isSelected;
    @Column(name = "TXT_STATUS", nullable = false)
   // @NotNull
    @ValidaStatus
    String Status;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}  , optional = false)
    @JoinColumn(name = "ID_ITINERARY", referencedColumnName = "ID")
    private Itinerary itinerary;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "ID_AGENCY", referencedColumnName = "ID")
    private Agency agency;
     
     @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "ID_FLIGHT", referencedColumnName = "ID")
    private Flight flight;
      
       @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL}, optional = true)
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID")
    private Hotel hotel;

    public Quote() {
    }

    public Integer getId() {
        return id;
    }
     

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Quote other = (Quote) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
