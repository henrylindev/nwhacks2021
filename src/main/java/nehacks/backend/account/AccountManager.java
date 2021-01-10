package nehacks.backend.account;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nwhacks.backend.timesheet.Timesheet;
@Dependent
@Stateless
@Path("/accounts")
public class AccountManager implements Serializable {
	
    @GET
    @Produces("application/json")
	public Account[] getAll() {
        return new Account[0];
    }
	
}
