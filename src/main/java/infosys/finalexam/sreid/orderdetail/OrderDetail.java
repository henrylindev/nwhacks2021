package infosys.finalexam.sreid.orderdetail;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import infosys.finalexam.sreid.order.OrderManager;
@Entity
@Table(name="orderdetails")
@IdClass(OrderDetailID.class)
@Named("orderDetail")
@SessionScoped
public class OrderDetail implements Serializable {

	@Transient
	@Inject private OrderDetailManager orderDetailManager;
	
	@Id
	@Column(name="orderNumber")
	protected int orderNumber;
	
	@Id
	@Column(name="productCode")
	protected String productCode;
	
	@Column(name="quantityOrdered")
	protected int quantityOrdered;
	
	@Column(name="priceEach")
	protected BigDecimal priceEach;
	
	@Column(name="orderLineNumber")
	protected Short orderLineNumber;
	
	@Transient
	protected boolean editable = false;
	
	@Transient
	protected boolean deletable = false;
	
	public OrderDetail() {}

	public OrderDetail(int orderNumber, String productCode, int quantityOrdered,
			BigDecimal priceEach, Short orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public BigDecimal getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}

	public Short getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
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
	
	public String addOrderDetail() {
		orderDetailManager.persist(this);
		return "displayOrderDetails";
	}
	
}
