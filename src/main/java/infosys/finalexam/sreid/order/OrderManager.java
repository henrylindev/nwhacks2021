package infosys.finalexam.sreid.order;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
@Stateless
public class OrderManager implements Serializable {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	public Order find(int orderNumber) {
    	return em.find(Order.class, orderNumber);
    }
	
	public void remove(Order order) {
    	order = find(order.getOrderNumber());
    	em.remove(order);
    }
	
	public void persist(Order order) {
		System.out.println("changing: " + order.getStatus());
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
