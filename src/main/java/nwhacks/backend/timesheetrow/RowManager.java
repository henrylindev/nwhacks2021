package nwhacks.backend.timesheetrow;

import java.io.Serializable;
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
import nwhacks.backend.project.ProjectManager;
import nwhacks.backend.timesheet.Timesheet;

@Dependent
@Stateless
public class RowManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	@Inject @Dependent private ProjectManager projectManager;
	
	public TimesheetRow[] getAll() {
		TypedQuery<TimesheetRow> query = em.createQuery("select t from TimesheetRow t",
        		TimesheetRow.class); 
        List<TimesheetRow> timesheetRows = query.getResultList();
        TimesheetRow[] timesheetRowArr = new TimesheetRow[timesheetRows.size()];
        for (int i = 0; i < timesheetRowArr.length; i++) {
        	timesheetRowArr[i] = timesheetRows.get(i);
        }
        return timesheetRowArr;
    }
	
	public TimesheetRow[] search(String projName) {
		Project p = projectManager.search(projName);
		UUID projId = p.getProjectId();
    	TypedQuery<TimesheetRow> query = em.createQuery(
    			"SELECT t FROM TimesheetRow t WHERE t.projectId = :projId", TimesheetRow.class)
    			.setParameter("projId", projId);
    	List<TimesheetRow> timesheets = query.getResultList();
    	TimesheetRow[] timesheet = new TimesheetRow[timesheets.size()];
        for (int i = 0; i < timesheet.length; i++) {
        	timesheet[i] = timesheets.get(i);
        }
        return timesheet;
    }
	
}
