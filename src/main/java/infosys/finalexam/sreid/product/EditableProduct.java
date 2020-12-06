package infosys.finalexam.sreid.product;

import java.io.Serializable;
import java.math.BigDecimal;


public class EditableProduct extends Product implements Serializable {

	private boolean editable = false;
	private boolean deletable = false;
	
	public EditableProduct() {
		super();
	}
	
	public EditableProduct(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Short quantityInStock, BigDecimal buyPrice,
			BigDecimal msrp) {
		super(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice,
				msrp);
	}
	
	public EditableProduct(Product p) {
		super(p.productCode, p.productName, p.productLine, p.productScale, p.productVendor, p.productDescription, p.quantityInStock, p.buyPrice,
				p.msrp);
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
