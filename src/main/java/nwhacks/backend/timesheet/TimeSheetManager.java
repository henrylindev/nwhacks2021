package nwhacks.backend.timesheet;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nwhacks.backend.employee.Employee;
import nwhacks.backend.employee.EmployeeManager;
import nwhacks.backend.project.Project;

@Dependent
@Stateless
public class TimeSheetManager {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	@Inject @Dependent private EmployeeManager employeeManager;
	public Timesheet[] getAll() {
        TypedQuery<Timesheet> query = em.createQuery("select t from Timesheet t",
        		Timesheet.class); 
        List<Timesheet> timesheets = query.getResultList();
        Timesheet[] timesheetArr = new Timesheet[timesheets.size()];
        for (int i = 0; i < timesheetArr.length; i++) {
        	timesheetArr[i] = timesheets.get(i);
        }
        return timesheetArr;
    }
	
	public Timesheet[] search(String empUserName) {
		Employee e = employeeManager.search(empUserName);
		UUID empId = e.getId();
    	TypedQuery<Timesheet> query = em.createQuery(
    			"SELECT t FROM Timesheet t WHERE t.empId = :sheetEmpId", Timesheet.class)
    			.setParameter("sheetEmpId", empId);
    	List<Timesheet> timesheets = query.getResultList();
    	Timesheet[] timesheet = new Timesheet[timesheets.size()];
        for (int i = 0; i < timesheet.length; i++) {
        	timesheet[i] = timesheets.get(i);
        }
        return timesheet;
    }
	
	public Timesheet searchById(UUID sheetId) {
    	TypedQuery<Timesheet> query = em.createQuery(
    			"SELECT t FROM Timesheet t WHERE t.sheetId = :sheetId", Timesheet.class)
    			.setParameter("sheetId", sheetId);
    	List<Timesheet> timesheets = query.getResultList();
    	return timesheets.get(0);
    }
	
}
