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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Darllan Costa
 */

@Entity
@Access(AccessType.FIELD)
public class Bank_Details implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Column(name = "TXT_ACCOUNT_NAME", nullable = false, length = 255)
    String account_Name;
    @CreditCardNumber
    @NotNull
    @Size(max = 50)
    @Column(name = "TXT_ACCOUNT_NUMBER", nullable = false, length = 50)
    String account_Number;
    @NotNull
    @Column(name = "TXT_ACCOUNT_AGENCY", nullable = false)
    String account_Agency;
    @NotNull
    @Column(name = "TXT_ACCOUNT_TYPE", nullable = false, length = 255)
    String account_Type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_Name() {
        return account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    public String getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }
    
    

    public Bank_Details() {
    }

    public String getAccount_Agency() {
        return account_Agency;
    }

    public void setAccount_Agency(String account_Agency) {
        this.account_Agency = account_Agency;
    }

    public String getAccount_Type() {
        return account_Type;
    }

    public void setAccount_Type(String account_Type) {
        this.account_Type = account_Type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Bank_Details other = (Bank_Details) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
