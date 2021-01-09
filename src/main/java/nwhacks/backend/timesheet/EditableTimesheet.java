package nwhacks.backend.timesheet;

import java.sql.Date;

import nwhacks.backend.timesheetrow.TimesheetRow;

public class EditableTimesheet extends Timesheet {
    
    private boolean editable = false;
    private boolean deletable = false;
    
    public EditableTimesheet() {
        super();
    }
    
    public EditableTimesheet(Timesheet t) {
        super(t.getSheetId(), t.getProjectId(), t.getRowArray(), t.getEmpId(), t.getDate());
    }
    
    public EditableTimesheet(String id, String projectId, TimesheetRow[] rows, String empId, Date date) {
        super(id, projectId, rows, empId, date);
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the deletable
     */
    public boolean isDeletable() {
        return deletable;
    }

    /**
     * @param deletable the deletable to set
     */
    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }
    
    
    
}
