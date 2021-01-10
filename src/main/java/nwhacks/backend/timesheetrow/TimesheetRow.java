package nwhacks.backend.timesheetrow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="timesheetrow")
@Named("timesheetRow")
@SessionScoped
public class TimesheetRow implements Serializable {
    
	@Id
	@Column(name="rowid")
	@Type(type = "uuid-char")
    private UUID rowId;
	
	@Column(name="sheetid")
	@Type(type = "uuid-char")
    private UUID sheetId;
	
	@Column(name="hours")
    private Short hours;
    
	@Column(name="projectId")
	@Type(type = "uuid-char")
    private UUID projectId;
    
    public TimesheetRow() {
        super();
    }

    public TimesheetRow(UUID sheetID, Short hours, UUID projectID) {
        super();
        this.rowId = UUID.randomUUID();
        this.sheetId = sheetID;
        this.hours = hours;
        this.projectId = projectID;
    }

    public UUID getSheetID() {
        return sheetId;
    }

    public void setSheetID(UUID sheetID) {
        this.sheetId = sheetID;
    }

    public Short getHours() {
        return hours;
    }

    public void setHours(Short hours) {
        this.hours = hours;
    }

    public UUID getProjectID() {
        return projectId;
    }

    public void setProjectID(UUID projectID) {
        this.projectId = projectID;
    }

	public UUID getRowId() {
		return rowId;
	}

	public void setRowId(UUID rowId) {
		this.rowId = rowId;
	}

	public UUID getSheetId() {
		return sheetId;
	}

	public void setSheetId(UUID sheetId) {
		this.sheetId = sheetId;
	}
    
	public String toString() {
		return "rowid: " + this.rowId + " sheetid: " + this.sheetId + " hours: " + this.hours 
				+ " projectId: " + this.projectId;
	}
    
    
}
