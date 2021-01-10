package nwhacks.backend.project;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nwhacks.backend.employee.Employee;
import nwhacks.backend.timesheet.Timesheet;

@Dependent
@Stateless
public class ProjectManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
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
	
	public Project searchById(UUID projId) {
    	TypedQuery<Project> query = em.createQuery(
    			"SELECT p FROM Project p WHERE p.projectId = :projId", Project.class)
    			.setParameter("projId", projId);
    	List<Project> projects = query.getResultList();
    	return projects.get(0);
    }
	
}
