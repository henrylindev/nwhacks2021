package nwhacks.backend.cost;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nwhacks.backend.employee.Employee;
import nwhacks.backend.employee.EmployeeManager;
import nwhacks.backend.project.Project;
import nwhacks.backend.project.ProjectManager;
import nwhacks.backend.timesheet.Timesheet;

@Dependent
@Stateless
@Path("/wages")
public class WageManager {
    
    @Inject @Dependent private ProjectManager projectManager;
    
    @PersistenceContext(unitName="inventory-jpa") EntityManager em;
    
    @GET
    @Produces("application/json")
    public WageCost[] getAll() {
        TypedQuery<WageCost> query = em.createQuery("select wc from WageCost wc",
                WageCost.class); 
        List<WageCost> costs = query.getResultList();
        WageCost[] empArr = new WageCost[costs.size()];
        for (int i = 0; i < empArr.length; i++) {
            empArr[i] = costs.get(i);
        }
        return empArr;
    }
    
    public WageCost[] search(String projName) {
        Project p = projectManager.search(projName);
        UUID projId = p.getProjectId();
        TypedQuery<WageCost> query = em.createQuery(
                "SELECT wc FROM WageCost wc WHERE wc.projectId = :projectId", WageCost.class)
                .setParameter("projectId", projId);
        List<WageCost> wageCosts = query.getResultList();
        WageCost[] wageCostsArr = new WageCost[wageCosts.size()];
        for (int i = 0; i < wageCostsArr.length; i++) {
            wageCostsArr[i] = wageCosts.get(i);
        }
        return wageCostsArr;
    }
    
    @Path("/{projName}")
    @GET
    @Produces("application/json")
    public WageCost[] searchREST(@PathParam("projName") String projName) {
        return search(projName);
    }
    
}
