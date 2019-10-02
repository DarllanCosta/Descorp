/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Darllan Costa
 */
public class ValidadorStatus implements ConstraintValidator<ValidaStatus, String>{

    
    private List<String> status;
    
    @Override
    public void initialize(ValidaStatus validaStatus) {
        this.status = new ArrayList<>();
        this.status.add("new");
        this.status.add("waitingManager");
        this.status.add("approved");
        this.status.add("rejected");
        this.status.add("waitingTraveler");
        this.status.add("inAgency");
        this.status.add("choose");
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
       return valor == null ? false : status.contains(valor);
    }
    
}
