/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Guilherme Henrique
 */
@Entity
@Table(name = "TB_ADMIN")
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Admin extends User implements Serializable{
    
}
