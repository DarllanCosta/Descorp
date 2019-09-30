/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author ALUNO
 */
@Entity
@Access(AccessType.FIELD)
public class Agency implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer Id;
   @Column(name = "TXT_AGENCY_NAME", nullable = false, length = 255)
   @NotNull
   @Size(max = 255)
   String agencyName;
   @Column(name = "TXT_EMAIL", nullable = false, length = 50)
   @Email
   @NotNull
   String email;
   @NotNull
   @Size(max = 14)
   @Column(name = "TXT_PHONE")
   String phone; 
   
   
   //mapeamento 1 pra 1 de usuário para Endereço
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID")
    private Address address;
    
  //um para muitos quotes
    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quote> quotes;

    public Agency() {
    }

    public Integer getId() {
        return Id;
    }

    public Address getAddress() {
        return address;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }
    

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.Id);
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
        final Agency other = (Agency) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
   
}
