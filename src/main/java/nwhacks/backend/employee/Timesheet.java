package nwhacks.backend.employee;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Timesheet {

    @Transient
    @Inject private TimeSheetManager timeSheetManager;
    
    public Timesheet() {
        super();
    }
    
    public Timesheet(TimeSheetManager timeSheetManager, String sheetId, String projectId, TimesheetRow[] rowArray,
            String empId, Date date) {
        super();
        this.timeSheetManager = timeSheetManager;
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
 
}
