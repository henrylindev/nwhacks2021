package nwhacks.backend.timesheetrow;

public class EditableTimesheetRow extends TimesheetRow {

    private boolean editable = false;
    private boolean deletable = false;
    
    public EditableTimesheetRow() {
        super();
    }
    
    public EditableTimesheetRow(TimesheetRow t) {
        super(t.getSheetID(), t.getHours(), t.getProjectID());
    }
    
    public EditableTimesheetRow(String sheetId, double hours, String projectId) {
        super(sheetId, hours, projectId);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }
    
}
