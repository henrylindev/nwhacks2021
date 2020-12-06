package infosys.finalexam.sreid.customer;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customers")
@Named("customer")
@SessionScoped
public class Customer implements Serializable {

	@Transient
	@Inject private CustomerManager customerManager;
	
	@Id
	@Column(name="customerNumber")
	protected int customerNumber;
	
	@Column(name="customerName")
	protected String customerName;
	
	@Column(name="contactLastName")
	protected String contactLastName;
	
	@Column(name="contactFirstName")
	protected String contactFirstName;
	
	@Column(name="phone")
	protected String phone;
	
	@Column(name="addressLine1")
	protected String addressLine1;
	
	@Column(name="addressLine2")
	protected String addressLine2;
	
	@Column(name="city")
	protected String city;
	
	@Column(name="state")
	protected String state;
	
	@Column(name="postalCode")
	protected String postalCode;
	
	@Column(name="country")
	protected String country;
	
	@Column(name="salesRepEmployeeNumber")
	protected Integer salesRepEmployeeNumber;
	
	@Column(name="creditLimit")
	protected BigDecimal creditLimit;
	
	public Customer() {}

	public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, Integer salesRepEmployeeNumber, BigDecimal creditLimit) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}
	
	public Customer(EditableCustomer c) {
		this.customerNumber = c.customerNumber;
		this.customerName = c.customerName;
		this.contactLastName = c.contactLastName;
		this.contactFirstName = c.contactFirstName;
		this.phone = c.phone;
		this.addressLine1 = c.addressLine1;
		this.addressLine2 = c.addressLine2;
		this.city = c.city;
		this.state = c.state;
		this.postalCode = c.postalCode;
		this.country = c.country;
		this.salesRepEmployeeNumber = c.salesRepEmployeeNumber;
		this.creditLimit = c.creditLimit;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(Integer salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public String addCustomer() {
		customerManager.persist(this);
		return "displayCustomers";
	}
	
}
