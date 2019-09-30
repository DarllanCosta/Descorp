/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Guilherme Henrique
 */
@Entity
@Table(name="TB_PROJECTCLIENTE") 
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName = "ID")
public class ProjectCliente extends Project implements Serializable{
    
    @Column(name = "ClientName")
    @NotNull
    @Size(max = 30)
    String clientName;
    @Column(name ="Allocation")
    Boolean allocation;

    public ProjectCliente() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Boolean getAllocation() {
        return allocation;
    }

    public void setAllocation(Boolean allocation) {
        this.allocation = allocation;
    }

   
    
    
}
