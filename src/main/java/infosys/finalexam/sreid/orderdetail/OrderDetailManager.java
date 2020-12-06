package infosys.finalexam.sreid.orderdetail;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import infosys.finalexam.sreid.order.Order;

@Dependent
@Stateless
public class OrderDetailManager {
	@PersistenceContext(unitName="inventory-jpa") EntityManager em;
	
	public OrderDetail find(int orderNumber) {
    	return em.find(OrderDetail.class, orderNumber);
    }
	
	public void remove(OrderDetail od) {
    	od = find(od.getOrderNumber());
    	em.remove(od);
    }
	
	public void persist(OrderDetail od) {
    	em.persist(od);
    }
	
	public void merge(OrderDetail od) {
    	em.merge(od);
    }
	
	public OrderDetail[] search(int orderNumber) {
    	TypedQuery<OrderDetail> query = em.createQuery(
    			"SELECT od FROM OrderDetail od WHERE o.orderNumber = :ordNum", OrderDetail.class)
    			.setParameter("ordNum", orderNumber);
    	List<OrderDetail> orderDetail = query.getResultList();
    	OrderDetail[] orderDetailArray = new OrderDetail[orderDetail.size()];
        for (int i=0; i < orderDetailArray.length; i++) {
        	orderDetailArray[i] = orderDetail.get(i);
        }
        return orderDetailArray;
    }
	
	public OrderDetail[] getAll() {
        TypedQuery<OrderDetail> query = em.createQuery("select od from OrderDetail od",
                OrderDetail.class); 
        List<OrderDetail> orderDetails = query.getResultList();
        OrderDetail[] orderDetailArray = new OrderDetail[orderDetails.size()];
        for (int i=0; i < orderDetailArray.length; i++) {
        	orderDetailArray[i] = orderDetails.get(i);
        }
        return orderDetailArray;
    }
}
