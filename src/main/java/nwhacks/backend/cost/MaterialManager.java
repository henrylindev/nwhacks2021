package nwhacks.backend.cost;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nwhacks.backend.employee.Employee;

@Dependent
@Stateless
@Path("/materials")
public class MaterialManager {
    
    @PersistenceContext(unitName="inventory-jpa") EntityManager em;
    
    @GET
    @Produces("application/json")
    public MaterialCost[] getAll() {
        TypedQuery<MaterialCost> query = em.createQuery("select mc from MaterialCost mc",
                MaterialCost.class); 
        List<MaterialCost> employees = query.getResultList();
        MaterialCost[] empArr = new MaterialCost[employees.size()];
        for (int i = 0; i < empArr.length; i++) {
            empArr[i] = employees.get(i);
        }
        return empArr;
    }
    
}




