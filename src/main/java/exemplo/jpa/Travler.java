/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Guilherme Henrique
 */
@Entity
@Table(name="TB_TRAVLER") 
@DiscriminatorValue(value = "T")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName = "ID")
public class Travler extends User implements Serializable{
    //mapeamento 1 pra 1 de usuário para conta bancária
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_BANK_DETAILS", referencedColumnName = "ID")
    private Bank_Details bank_Details;
    
     //mapeamento 1 pra n de usuário para requests
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests;
    
    public Bank_Details getBank_Details() {
        return bank_Details;
    }

    public void setBank_Details(Bank_Details bank_Details) {
        this.bank_Details = bank_Details;
    }
    
    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
