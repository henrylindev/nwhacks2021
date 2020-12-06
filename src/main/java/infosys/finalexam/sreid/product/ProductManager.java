package infosys.finalexam.sreid.product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
@Stateless
public class ProductManager implements Serializable {
    @PersistenceContext(unitName="inventory-jpa") EntityManager em;
    
    public void remove(Product product) {
    	product = find(product.getProductCode());
    	em.remove(product);
    }
    
    public void merge(EditableProduct product) {
    	Product prod = new Product(product);
    	em.merge(prod);
    }
    
    public void persist(Product product) {
    	em.persist(product);
    }
    
    public Product find(String productCode) {
    	return em.find(Product.class, productCode);
    }
    
    public Product[] search(String productName) {
    	TypedQuery<Product> query = em.createQuery(
    			"SELECT p FROM Product p WHERE p.productName LIKE :prodName", Product.class)
    			.setParameter("prodName", "%" + productName + "%");
    	List<Product> products = query.getResultList();
        Product[] prodarray = new Product[products.size()];
        for (int i=0; i < prodarray.length; i++) {
        	prodarray[i] = products.get(i);
        }
        System.out.println("prodarray: " + prodarray[0].getProductName());
        return prodarray;
    }
    
    public Product[] getAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p",
                Product.class); 
        List<Product> products = query.getResultList();
        Product[] prodarray = new Product[products.size()];
        for (int i=0; i < prodarray.length; i++) {
        	prodarray[i] = products.get(i);
        }
        return prodarray;
    }
}
