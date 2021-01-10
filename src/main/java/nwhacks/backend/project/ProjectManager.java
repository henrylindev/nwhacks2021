package nwhacks.backend.project;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nwhacks.backend.employee.Employee;
import nwhacks.backend.timesheet.Timesheet;

@Dependent
@Stateless
@Path("/projects")
public class ProjectManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	@GET
    @Produces("application/json")
	public Project[] getAll() {
        TypedQuery<Project> query = em.createQuery("select p from Project p",
        		Project.class); 
        List<Project> projects = query.getResultList();
        Project[] projArr = new Project[projects.size()];
        for (int i = 0; i < projArr.length; i++) {
        	projArr[i] = projects.get(i);
        }
        return projArr;
    }
	
	public Project search(String projName) {
    	TypedQuery<Project> query = em.createQuery(
    			"SELECT p FROM Project p WHERE p.projectName LIKE :projName", Project.class)
    			.setParameter("projName", "%" + projName + "%");
    	List<Project> projects = query.getResultList();
    	System.out.println("input: " + projName);
    	
        return projects.get(0);
    }
	
	@Path("/name/{projName}")
    @GET
    @Produces("application/json")
	public Project searchREST(@PathParam("projName") String projName) {
	    return search(projName);
    }
	
	public Project searchById(UUID projId) {
    	TypedQuery<Project> query = em.createQuery(
    			"SELECT p FROM Project p WHERE p.projectId = :projId", Project.class)
    			.setParameter("projId", projId);
    	List<Project> projects = query.getResultList();
    	return projects.get(0);
    }
	
	@Path("/id/{projId}")
    @GET
    @Produces("application/json")
    public Project searchByIdREST(@PathParam("projId") UUID projId) {
        return searchById(projId);
    }
	
}
