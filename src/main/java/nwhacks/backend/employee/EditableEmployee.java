package nwhacks.backend.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class EditableEmployee extends Employee implements Serializable {
	private boolean editable = false;
	private boolean deletable = false;
	
	public EditableEmployee() {
		super();
	}

	public EditableEmployee(Employee e) {
		super(e.id, e.salary, e.benefits, e.netRate);
	}

	public EditableEmployee(UUID id, BigDecimal salary, BigDecimal benefits, Short netRate) {
		super(id, salary, benefits, netRate);
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
