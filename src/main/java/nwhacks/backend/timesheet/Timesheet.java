package nwhacks.backend.timesheet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import nwhacks.backend.timesheetrow.TimesheetRow;
@Entity
@Table(name="timesheets")
@Named("timesheet")
@SessionScoped
public class Timesheet implements Serializable {

    @Transient
    @Inject private TimeSheetManager timeSheetManager;
    
    public Timesheet() {
        super();
    }
    
    public Timesheet(UUID sheetId, UUID empId, Date date) {
        super();
        this.sheetId = UUID.randomUUID();;
//        this.projectId = projectId;
//        this.rowArray = rowArray;
        this.empId = empId;
        this.date = date;
    }

    @Id
    @Column(name="sheetid")
    @Type(type = "uuid-char")
    private UUID sheetId;
    
    @Column(name="empid")
    @Type(type = "uuid-char")
    private UUID empId;
    
    @Column(name="timesheetdate")
    private Date date;

    /**
     * @return the timeSheetManager
     */
    public TimeSheetManager getTimeSheetManager() {
        return timeSheetManager;
    }

    /**
     * @param timeSheetManager the timeSheetManager to set
     */
    public void setTimeSheetManager(TimeSheetManager timeSheetManager) {
        this.timeSheetManager = timeSheetManager;
    }

    /**
     * @return the sheetId
     */
    public UUID getSheetId() {
        return sheetId;
    }

    /**
     * @param sheetId the sheetId to set
     */
    public void setSheetId(UUID sheetId) {
        this.sheetId = sheetId;
    }

//    /**
//     * @return the projectId
//     */
//    public UUID getProjectId() {
//        return projectId;
//    }
//
//    /**
//     * @param projectId the projectId to set
//     */
//    public void setProjectId(UUID projectId) {
//        this.projectId = projectId;
//    }
//
//    /**
//     * @return the rowArray
//     */
//    public TimesheetRow[] getRowArray() {
//        return rowArray;
//    }
//
//    /**
//     * @param rowArray the rowArray to set
//     */
//    public void setRowArray(TimesheetRow[] rowArray) {
//        this.rowArray = rowArray;
//    }

    /**
     * @return the empId
     */
    public UUID getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(UUID empId) {
        this.empId = empId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String toString() {
    	return "Sheet ID: " + this.sheetId + "Employee ID: " + this.getEmpId()
    		+ "date" + this.date;
    }
 
}
