package infosys.finalexam.sreid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("productList")
@ConversationScoped
public class ProductList implements Serializable {
	@Inject @Dependent private ProductManager productManager;
	private List<EditableProduct> list;
	
	public List<EditableProduct> refreshList() {
		Product[] products = productManager.getAll();
        list = new ArrayList<EditableProduct>();
        for (int i = 0; i < products.length; i++) {
            list.add(new EditableProduct(products[i]));
        }
        System.out.println("List size: " + list.size());
        return list;
    }
}
