package infosys.finalexam.sreid.customer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import infosys.finalexam.sreid.product.Product;

@Dependent
@Stateless
@Path("/customers")
public class CustomerManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	public void remove(Customer customer) {
		customer = find(customer.getCustomerNumber());
    	em.remove(customer);
    }
    
    public void merge(EditableCustomer customer) {
    	Customer cust = new Customer(customer);
    	em.merge(cust);
    }
    
    @Path("/addCustomer")
	@POST
	public void persistREST(@QueryParam("customerNumber") int customerNumber, 
			@QueryParam("customerName") String customerName, 
			@QueryParam("contactLastName") String contactLastName, 
			@QueryParam("contactFirstName") String contactFirstName, 
			@QueryParam("phone") String phone, 
			@QueryParam("addressLine1") String addressLine1, 
			@QueryParam("addressLine2") String addressLine2,
			@QueryParam("city") String city, 
			@QueryParam("state") String state, 
			@QueryParam("postalCode") String postalCode, 
			@QueryParam("country") String country, 
			@QueryParam("salesRepEmployeeNumber") int salesRepEmployeeNumber,
			@QueryParam("creditLimit") BigDecimal creditLimit) {
    	Customer customer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone,
    			addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
    	em.persist(customer);
    }
	
    public void persist(Customer customer) {
    	em.persist(customer);
    }
    
    public Customer find(int customerNumber) {
    	return em.find(Customer.class, customerNumber);
    }
    
    public Customer[] search(String customerName) {
    	TypedQuery<Customer> query = em.createQuery(
    			"SELECT c FROM Customer c WHERE c.customerName LIKE :custName", Customer.class)
    			.setParameter("custName", "%" + customerName + "%");
    	List<Customer> customers = query.getResultList();
        Customer[] custarr = new Customer[customers.size()];
        for (int i=0; i < custarr.length; i++) {
        	custarr[i] = customers.get(i);
        }
        return custarr;
    }
    
    public Customer[] getAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c",
        		Customer.class); 
        List<Customer> customers = query.getResultList();
        Customer[] custarray = new Customer[customers.size()];
        for (int i=0; i < custarray.length; i++) {
        	custarray[i] = customers.get(i);
        }
        return custarray;
    }
    
}
