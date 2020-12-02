package infosys.finalexam.sreid;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Dependent
@Stateless
@Path("/products")
public class ProductManager implements Serializable {
    @PersistenceContext(unitName="inventory-jpa") EntityManager em;
    
    public Product[] getAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p",
                Product.class); 
        List<Product> products = query.getResultList();
        Product[] prodarray = new Product[products.size()];
        for (int i=0; i < prodarray.length; i++) {
        	prodarray[i] = products.get(i);
        }
        System.out.println("Refreshed list from DAO: " + Arrays.deepToString(prodarray));
        return prodarray;
    }
}
