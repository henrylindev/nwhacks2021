package infosys.finalexam.sreid.orderdetail;

import java.io.Serializable;

public class OrderDetailID implements Serializable {

	private int orderNumber;
	private String productCode;
	
	public OrderDetailID(int orderNumber, String productCode) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}
	
	public OrderDetailID() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailID other = (OrderDetailID) obj;
		if (orderNumber != other.orderNumber)
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}
	
	
	
}
