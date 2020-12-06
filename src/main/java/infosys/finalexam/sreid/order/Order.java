package infosys.finalexam.sreid.order;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import infosys.finalexam.sreid.product.ProductManager;

@Entity
@Table(name="orders")
@Named("order")
@SessionScoped
public class Order implements Serializable {

	@Transient
	@Inject private OrderManager orderManager;
	
	@Id
	@Column(name="orderNumber")
	protected int orderNumber;
	
	@Column(name="orderDate")
	@Temporal(TemporalType.DATE)
	protected Date orderDate;
	
	@Column(name="requiredDate")
	@Temporal(TemporalType.DATE)
	protected Date requiredDate;
	
	@Column(name="shippedDate")
	@Temporal(TemporalType.DATE)
	protected Date shippedDate;
	
	@Column(name="status")
	protected String status;
	
	@Column(name="comments")
	@Type(type = "text")
	protected String comments;
	
	@Column(name="customerNumber")
	protected int customerNumber;
	
	@Transient
	protected boolean editable = false;
	
	@Transient
	protected boolean deletable = false;
	
	public Order() {}

	public Order(OrderManager orderManager, int orderNumber, Date orderDate, Date requiredDate, Date shippedDate,
			String status, String comments, int customerNumber) {
		super();
		this.orderManager = orderManager;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		System.out.println("setting date: " + orderDate);
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
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
	
	public String addOrder() {
		orderManager.persist(this);
		return "displayOrders";
	}
	
}
