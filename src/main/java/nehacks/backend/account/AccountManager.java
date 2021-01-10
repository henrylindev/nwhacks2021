package nehacks.backend.account;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.TypedQuery;

import nwhacks.backend.timesheet.Timesheet;
@Dependent
@Stateless
public class AccountManager implements Serializable {
	
	public Account[] getAll() {
        return new Account[0];
    }
	
}
