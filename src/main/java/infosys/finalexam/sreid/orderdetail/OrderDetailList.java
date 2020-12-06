package infosys.finalexam.sreid.orderdetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import infosys.finalexam.sreid.order.Order;
import infosys.finalexam.sreid.order.OrderManager;

@Named("orderDetailList")
@ConversationScoped
public class OrderDetailList implements Serializable {
	@Inject @Dependent private OrderDetailManager orderDetailManager;
	private List<OrderDetail> list;
	@Inject Conversation conversation;
	private int searchTerm;
	
	public List<OrderDetail> getList() {
		if(!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }
	
	public List<OrderDetail> refreshList() {
		OrderDetail[] orderDetails = orderDetailManager.getAll();
        list = new ArrayList<OrderDetail>();
        for (int i = 0; i < orderDetails.length; i++) {
            list.add(orderDetails[i]);
        }
        return list;
    }
	
	public void search() {
		OrderDetail[] orderDetails = orderDetailManager.search(searchTerm);
		list = new ArrayList<OrderDetail>();
		for(int i = 0; i < orderDetails.length; i++) {
			list.add(orderDetails[i]);
		}
	}
	
	public String deleteOrderDetail(OrderDetail od) {
		orderDetailManager.remove(od);
        list.remove(od);
        return null;
    }
	
	public String save() {
        for (OrderDetail od : list) {
            if (od.isEditable()) {
            	orderDetailManager.merge(od);
                od.setEditable(false);
            }
        }
        return null;
    }
	
	public String goToProducts() {
        conversation.end();
        return "displayProducts";
    }
	
	public String addOrderDetail() {
        conversation.end();
        return "addOrderDetail";
    }
	
	public int getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(int searchTerm) {
		this.searchTerm = searchTerm;
	}
	
}
