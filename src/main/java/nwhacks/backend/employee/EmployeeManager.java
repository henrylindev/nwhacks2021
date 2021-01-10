package nwhacks.backend.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Dependent
@Stateless
@Path("/employees")
public class EmployeeManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	@GET
	@Produces("application/json")
    public Employee[] getAll() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e",
        		Employee.class); 
        List<Employee> employees = query.getResultList();
        Employee[] empArr = new Employee[employees.size()];
        for (int i = 0; i < empArr.length; i++) {
        	empArr[i] = employees.get(i);
        }
        return empArr;
    }
    
//    public Employee[] search(String empId) {
//    	TypedQuery<Employee> query = em.createQuery(
//    			"SELECT e FROM Employee e WHERE e.empname LIKE :empId", Employee.class)
//    			.setParameter("empId", "%" + empId + "%");
//    	List<Employee> employees = query.getResultList();
//    	Employee[] empArr = new Employee[employees.size()];
//        for (int i=0; i < empArr.length; i++) {
//        	empArr[i] = employees.get(i);
//        }
//        return empArr;
//    }

	// still a string, might need to change type to UUID
    public Employee search(String empId) {
    	TypedQuery<Employee> query = em.createQuery(
    			"SELECT e FROM Employee e WHERE e.name LIKE :empId", Employee.class)
    			.setParameter("empId", "%" + empId + "%");
    	List<Employee> employees = query.getResultList();
    	
        return employees.get(0);
    }
    
    @Path("/{empId}")
    @GET
    @Produces("application/json")
    public Employee searchREST(@PathParam("empId") String empId) {
        return search(empId);
    }
    
}
