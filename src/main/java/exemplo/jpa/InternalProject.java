/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guilherme Henrique
 */
@Entity
@Table(name="TB_INTERNALPROJECT") 
@DiscriminatorValue(value = "I")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = "InternalProject.porDataDeInico",
                    query = "SELECT u FROM InternalProject u WHERE u.startDate LIKE :startDate ORDER BY u.id"
            ),
            @NamedQuery(
                    name = "InternalProject.porDepartamento",
                    query = "SELECT u FROM InternalProject u WHERE u.department LIKE :department ORDER BY u.id"
            )
        }
)
public class InternalProject extends Project implements Serializable{
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    @NotNull
    Date startDate;
    
    @Column(name = "FinalDate")
    @Temporal(TemporalType.DATE)
    Date finalDate;
    
    @Column(name = "department")
    @NotNull
    String department;

    public InternalProject() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
