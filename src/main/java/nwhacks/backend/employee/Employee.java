package nwhacks.backend.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="employees")
@Named("employee")
@SessionScoped
public class Employee implements Serializable {

	@Transient
	@Inject private EmployeeManager employeeManager;
	
	@Id
	@Column(name="id")
	protected UUID id;
	
	@Column(name="salary")
	protected BigDecimal salary;
	
	@Column(name="benefits")
	protected BigDecimal benefits;
	
	@Column(name="netrate")
	protected Short netRate;
	
	public Employee() {}

	public Employee(UUID id, BigDecimal salary, BigDecimal benefits, Short netRate) {
		super();
		this.id = UUID.randomUUID();
		this.salary = salary;
		this.benefits = benefits;
		this.netRate = netRate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getBenefits() {
		return benefits;
	}

	public void setBenefits(BigDecimal benefits) {
		this.benefits = benefits;
	}

	public Short getNetRate() {
		return netRate;
	}

	public void setNetRate(Short netRate) {
		this.netRate = netRate;
	}

}
