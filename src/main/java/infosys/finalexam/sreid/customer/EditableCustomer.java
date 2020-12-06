package infosys.finalexam.sreid.customer;

import java.io.Serializable;
import java.math.BigDecimal;

public class EditableCustomer extends Customer implements Serializable {
	private boolean editable = false;
	private boolean deletable = false;
	
	public EditableCustomer() {
		super();
	}

	public EditableCustomer(Customer c) {
		super(c.customerNumber, c.customerName, c.contactLastName, c.contactFirstName, c.phone, c.addressLine1, c.addressLine2, c.city, c.state,
				c.postalCode, c.country, c.salesRepEmployeeNumber, c.creditLimit);
	}

	public EditableCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, Integer salesRepEmployeeNumber, BigDecimal creditLimit) {
		super(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state,
				postalCode, country, salesRepEmployeeNumber, creditLimit);
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
