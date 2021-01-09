package nwhacks.backend.timesheetrow;

public class TimesheetRow {
    
    private String sheetID;
    private Double hours;
    private String projectID;
    
    public TimesheetRow() {
        super();
    }

    public TimesheetRow(String sheetID, Double hours, String projectID) {
        super();
        this.sheetID = sheetID;
        this.hours = hours;
        this.projectID = projectID;
    }

    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    
}
