package infosys.finalexam.sreid.product;

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

import org.hibernate.annotations.Type;

@Entity
@Table(name="products")
@Named("product")
@SessionScoped
public class Product implements Serializable {

	@Transient
	@Inject private ProductManager productManager;
	
	@Id
	@Column(name="productCode")
	protected String productCode;
	
	@Column(name="productName")
	protected String productName;
	
	@Column(name="productLine")
	protected String productLine;
	
	@Column(name="productScale")
	protected String productScale;
	
	@Column(name="productVendor")
	protected String productVendor;
	
	@Column(name="productDescription")
	@Type(type = "text")
	protected String productDescription;
	
	@Column(name="quantityInStock")
	protected Short quantityInStock;
	
	@Column(name="buyPrice")
	protected BigDecimal buyPrice;
	
	@Column(name="MSRP")
	protected BigDecimal msrp;
	
	public Product() {}

	public Product(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Short quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	
	public Product(EditableProduct p) {
		this.productCode = p.getProductCode();
		this.productName = p.getProductName();
		this.productLine = p.getProductLine(); 
		this.productScale = p.getProductScale();
		this.productVendor = p.getProductVendor();
		this.productDescription = p.getProductDescription(); 
		this.quantityInStock = p.getQuantityInStock();
		this.buyPrice = p.getBuyPrice();
		this.msrp = p.getMsrp();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Short getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public BigDecimal getMsrp() {
		return msrp;
	}

	public void setMsrp(BigDecimal msrp) {
		this.msrp = msrp;
	}

	public String addProduct() {
		productManager.persist(this);
		return "displayProducts";
	}
	
	
	
	
}
