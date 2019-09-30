/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.InternalProject;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CacheRetrieveMode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Darllan Costa
 */


public class InternalProjectCrudTest extends GenericTest{
    
    @Test
    public void persistirInternalProject(){
        logger.info("Executando persistirInternalProject()");
        InternalProject project = criarProjectClient();
         em.persist(project);
         em.flush();
         assertNotNull(project.getId());
        
    }
    
    @Test
    public void atualizarInteralProject() {

        logger.info("Atualizando ProjectCliente");
        
       
        String newProjectName = "Testando InternalProject";
        
        
        InternalProject project = em.find(InternalProject.class, 3);
        project.setProjectName(newProjectName);
       
        
        em.flush();
        em.clear();
        
        project = em.find(InternalProject.class, 3);
        assertEquals(newProjectName, project.getProjectName());
        

    }
   
    @Test
    public void atualizarInteralProjectMerge() {
        
        logger.info("Atualizando InternalProject com merge");
        
        Calendar newDate = Calendar.getInstance();
         newDate.set(Calendar.YEAR,2020);
         newDate.set(Calendar.MONTH, Calendar.DECEMBER);
         newDate.set(Calendar.DAY_OF_MONTH, 15);
        String newDescription = "apenas mais um teste";
        
        
        
        InternalProject project = em.find(InternalProject.class, 4);
        project.setFinalDate(newDate.getTime());
        project.setDescription(newDescription);
        em.clear();
        em.merge(project);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        project = em.find(InternalProject.class, 4, properties);
        assertEquals(newDescription, project.getDescription());
        assertEquals(newDate.getTime(), project.getFinalDate());

    }
    
    
    
    
    @Test
    public void removerInternalProject(){
        logger.info("Executando removerProjectCliente()");
        InternalProject project = em.find(InternalProject.class, 5);
        assertNotNull(project);
        em.remove(project);
        project = em.find(InternalProject.class, 5);
        assertNull(project);
        
    }
    
    
    private InternalProject criarProjectClient(){
        
         InternalProject project = new InternalProject();
         Calendar newDate = Calendar.getInstance();
         newDate.set(Calendar.YEAR,2020);
         newDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
         newDate.set(Calendar.DAY_OF_MONTH, 5);
         project.setStartDate(newDate.getTime());
         newDate.set(Calendar.MONTH, Calendar.OCTOBER);
         project.setFinalDate(newDate.getTime());
         project.setDescription("Projeto que pode render uma ótima parceiria");
         project.setProjectBudget(5684.00);
         project.setProjectName("Code Geass");
         project.setDepartment("ti");
      
        
        return project;
        
    }
    
    
    
    
}
