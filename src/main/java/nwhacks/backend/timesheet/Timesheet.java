package nwhacks.backend.timesheet;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import nwhacks.backend.timesheetrow.TimesheetRow;

public class Timesheet {

    @Transient
    @Inject private TimeSheetManager timeSheetManager;
    
    public Timesheet() {
        super();
    }
    
    public Timesheet(String sheetId, String projectId, TimesheetRow[] rowArray,
            String empId, Date date) {
        super();
        this.sheetId = sheetId;
        this.projectId = projectId;
        this.rowArray = rowArray;
        this.empId = empId;
        this.date = date;
    }

    @Id
    @Column(name="id")
    private String sheetId;

    @Column(name="salary")
    private String projectId;
    
    @Column(name="benefits")
    private TimesheetRow rowArray[];
    
    @Column(name="netrate")
    private String empId;
    
    @Column(name="data")
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
    public String getSheetId() {
        return sheetId;
    }

    /**
     * @param sheetId the sheetId to set
     */
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the rowArray
     */
    public TimesheetRow[] getRowArray() {
        return rowArray;
    }

    /**
     * @param rowArray the rowArray to set
     */
    public void setRowArray(TimesheetRow[] rowArray) {
        this.rowArray = rowArray;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
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
    
    
 
}
