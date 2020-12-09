package infosys.finalexam.sreid.order;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Dependent
@Stateless
@Path("/orders")
public class OrderManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	public Order find(int orderNumber) {
    	return em.find(Order.class, orderNumber);
    }
	
	public void remove(Order order) {
    	order = find(order.getOrderNumber());
    	em.remove(order);
    }
	
	@Path("/createOrder")
	@POST
	public String persistREST(@QueryParam("orderNumber") int orderNumber, 
			@QueryParam("orderDate") String orderDate, 
			@QueryParam("requiredDate") String requiredDate, 
			@QueryParam("shippedDate") String shippedDate,
			@QueryParam("status") String status, 
			@QueryParam("comments") String comments, 
			@QueryParam("customerNumber") int customerNumber) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date convertedOrderDate = new Date();
		Date convertedRequiredDate = new Date();
		Date convertedShippedDate = new Date();
		try {
			convertedOrderDate = formatter.parse(orderDate);
			convertedRequiredDate = formatter.parse(requiredDate);
			convertedShippedDate = formatter.parse(shippedDate);
		} catch (Exception e) {
			System.out.println("Client passed in a bad date");
			e.printStackTrace();
		}
		Order o = new Order(orderNumber, convertedOrderDate, convertedRequiredDate, 
				convertedShippedDate, status, comments, customerNumber);
		persist(o);
		return "success";
	}
	
	public void persist(Order order) {
    	em.persist(order);
    }
	
	public void merge(Order order) {
    	em.merge(order);
    }
	
	public Order[] search(int orderNumber) {
    	TypedQuery<Order> query = em.createQuery(
    			"SELECT o FROM Order o WHERE o.orderNumber = :ordNum", Order.class)
    			.setParameter("ordNum", orderNumber);
    	List<Order> orders = query.getResultList();
        Order[] orderarray = new Order[orders.size()];
        for (int i=0; i < orderarray.length; i++) {
        	orderarray[i] = orders.get(i);
        }
        return orderarray;
    }
	
	public Order[] getAll() {
        TypedQuery<Order> query = em.createQuery("select o from Order o",
                Order.class); 
        List<Order> orders = query.getResultList();
        Order[] orderarray = new Order[orders.size()];
        for (int i=0; i < orderarray.length; i++) {
        	orderarray[i] = orders.get(i);
        }
        return orderarray;
    }
	
}
