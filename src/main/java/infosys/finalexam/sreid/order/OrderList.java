package infosys.finalexam.sreid.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import infosys.finalexam.sreid.product.EditableProduct;
import infosys.finalexam.sreid.product.Product;
import infosys.finalexam.sreid.product.ProductManager;

@Named("orderList")
@ConversationScoped
public class OrderList implements Serializable {
	@Inject @Dependent private OrderManager orderManager;
	private List<Order> list;
	@Inject Conversation conversation;
	private int searchTerm;
	
	public List<Order> getList() {
		if(!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }
	
	public List<Order> refreshList() {
		Order[] orders = orderManager.getAll();
        list = new ArrayList<Order>();
        for (int i = 0; i < orders.length; i++) {
            list.add(orders[i]);
        }
        return list;
    }
	
	public void search() {
		Order[] orders = orderManager.search(searchTerm);
		list = new ArrayList<Order>();
		for(int i = 0; i < orders.length; i++) {
			list.add(orders[i]);
		}
	}
	
	public String deleteOrder(Order o) {
		orderManager.remove(o);
        list.remove(o);
        return null;
    }
	
	public String save() {
		System.out.println("running in save");
        for (Order o : list) {
        	System.out.println("order editable? " + o.getOrderNumber() + " " + o.isEditable());
            if (o.isEditable()) {
            	System.out.println("running in save");
            	orderManager.merge(o);
                o.setEditable(false);
            }
        }
        return null;
    }
	
	public String goToProducts() {
        conversation.end();
        return "displayProducts";
    }

    public String addOrder() {
        conversation.end();
        return "addOrder";
    }
    
    public int getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(int searchTerm) {
		this.searchTerm = searchTerm;
	}
}
