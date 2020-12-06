package infosys.finalexam.sreid.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Named("customerList")
@ConversationScoped
public class CustomerList implements Serializable {
	@Inject @Dependent private CustomerManager customerManager;
	private List<EditableCustomer> list;
	@Inject Conversation conversation;
	private String searchTerm;
	
	public List<EditableCustomer> getList() {
		if(!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }

	public List<EditableCustomer> refreshList() {
		Customer[] customers = customerManager.getAll();
        list = new ArrayList<EditableCustomer>();
        for (int i = 0; i < customers.length; i++) {
            list.add(new EditableCustomer(customers[i]));
        }
        return list;
    }
	
	public void search() {
		Customer[] customers = customerManager.search(searchTerm);
		list = new ArrayList<EditableCustomer>();
		for(int i = 0; i < customers.length; i++) {
			list.add(new EditableCustomer(customers[i]));
		}
	}
	
	public String deleteCustomer(EditableCustomer c) {
		customerManager.remove(c);
        list.remove(c);
        return null;
    }

	
	public String save() {
        for (EditableCustomer c : list) {
            if (c.isEditable()) {
            	customerManager.merge(c);
                c.setEditable(false);
            }
        }
        return null;
    }
    
    public String goToProduct() {
        conversation.end();
        return "displayProducts";
    }
    
    public String addCustomer() {
        conversation.end();
        return "addCustomer";
    }

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
