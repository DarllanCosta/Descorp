/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ALUNO
 */
@Entity
@Access(AccessType.FIELD)
public class Project implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer Id;
   String ProjectName;
   Double ProjectMoney;
   String Description;
   
}
