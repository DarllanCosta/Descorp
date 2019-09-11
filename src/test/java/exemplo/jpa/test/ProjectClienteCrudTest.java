/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.test;

import exemplo.jpa.ProjectCliente;
import static exemplo.jpa.test.GenericTest.logger;
import java.util.ArrayList;
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


public class ProjectClienteCrudTest extends GenericTest{
    
    @Test
    public void persistirProjectCliente(){
        logger.info("Executando persistirProjectCliente()");
        ProjectCliente project = new ProjectCliente();
         em.persist(project);
         em.flush();
         assertNotNull(project.getId());
        
    }
    
    @Test
    public void atualizarProjectCliente() {

        logger.info("Atualizando ProjectCliente");
        
        String newClienteName = "Beatriz";
        String newProjectName = "é incrivel";
        
        
        ProjectCliente project = em.find(ProjectCliente.class, 1);
        project.setClientName(newClienteName);
        project.setProjectName(newProjectName);
        
        em.flush();
        em.clear();
        
        project = em.find(ProjectCliente.class, 1);
        assertEquals(newClienteName, project.getClientName());
        assertEquals(newProjectName, project.getProjectName());
        

    }
   
    @Test
    public void atualizarProjectClienteMerge() {
        
        logger.info("Atualizando ProjectCliente com merge");
        
        String newDescription = "apenas mais um teste";
        String newClienteName = "Lelou";
        
        ProjectCliente project = em.find(ProjectCliente.class, 2);
        project.setClientName(newClienteName);
        project.setDescription(newDescription);
        em.clear();
        em.merge(project);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistance.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        project = em.find(ProjectCliente.class, 2, properties);
        assertEquals(newDescription, project.getDescription());
        assertEquals(newClienteName, project.getClientName());

    }
    
    
    
    
    @Test
    public void removerProjectCliente(){
        logger.info("Executando removerProjectCliente()");
        ProjectCliente project = em.find(ProjectCliente.class, 5);
        assertNotNull(project);
        em.remove(project);
        project = em.find(ProjectCliente.class, 5);
        assertNull(project);
        
    }
    
    
    private ProjectCliente criarProjectClient(){
        
        ProjectCliente project = new ProjectCliente();
        
         project.setAllocation(true);
         project.setClientName("Paulo");
         project.setDescription("Projeto que pode render uma ótima parceiria");
         project.setProjectBudget(5684.00);
         project.setProjectName("Code Geass");
      
        
        return project;
        
    }
    
    
    
    
}
