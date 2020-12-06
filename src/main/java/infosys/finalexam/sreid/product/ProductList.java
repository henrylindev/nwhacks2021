package infosys.finalexam.sreid.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import infosys.finalexam.sreid.customer.EditableCustomer;

@Named("productList")
@ConversationScoped
public class ProductList implements Serializable {
	@Inject @Dependent private ProductManager productManager;
	private List<EditableProduct> list;
	@Inject Conversation conversation;
	private String searchTerm;
	
	public List<EditableProduct> getList() {
		if(!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }
	
	public List<EditableProduct> refreshList() {
		Product[] products = productManager.getAll();
        list = new ArrayList<EditableProduct>();
        for (int i = 0; i < products.length; i++) {
            list.add(new EditableProduct(products[i]));
        }
        return list;
    }
	
	public void search() {
		Product[] products = productManager.search(searchTerm);
		list = new ArrayList<EditableProduct>();
		for(int i = 0; i < products.length; i++) {
			list.add(new EditableProduct(products[i]));
		}
	}
	
	public String deleteProduct(EditableProduct p) {
		productManager.remove(p);
        list.remove(p);
        return null;
    }
	
	public String save() {
        for (EditableProduct p : list) {
            if (p.isEditable()) {
            	productManager.merge(p);
                p.setEditable(false);
            }
        }
        return null;
    }
    
    public String goToCustomers() {
        conversation.end();
        return "displayCustomers";
    }

    public String addProduct() {
        conversation.end();
        return "addProduct";
    }
    
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
    
    
}
