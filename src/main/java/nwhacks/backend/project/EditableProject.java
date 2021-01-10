package nwhacks.backend.project;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import nwhacks.backend.employee.Employee;


public class EditableProject extends Project implements Serializable {
	private boolean editable = false;
	private boolean deletable = false;
	
	public EditableProject(Project p) {
		super(p.projectId, p.projectName);
	}
	
	public EditableProject(UUID projectId, String projectName) {
		super(projectId, projectName);
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
