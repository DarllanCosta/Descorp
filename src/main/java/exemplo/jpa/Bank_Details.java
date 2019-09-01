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
public class Bank_Details implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String acount_Name;
    String acount_Number;
    String account_Agency;
    String account_Type;

    public String getAcount_Name() {
        return acount_Name;
    }

    public void setAcount_Name(String acount_Name) {
        this.acount_Name = acount_Name;
    }

    public String getAcount_Number() {
        return acount_Number;
    }

    public void setAcount_Number(String acount_Number) {
        this.acount_Number = acount_Number;
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
