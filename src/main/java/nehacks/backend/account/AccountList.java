package nehacks.backend.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

//import nwhacks.backend.account.EditableAccount;
//import nwhacks.backend.account.Account;
//import nwhacks.backend.account.AccountManager;

@Named("accountList")
@ConversationScoped
public class AccountList implements Serializable {
    
    @Inject @Dependent private AccountManager accountManager;
    private List<EditableAccount> list;
    @Inject Conversation conversation;
    
    public List<EditableAccount> getList() {
        if(!conversation.isTransient()) {
            conversation.end();
        }
        conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }

    public List<EditableAccount> refreshList() {
        Account[] accounts = accountManager.getAll();
        list = new ArrayList<EditableAccount>();
        for (int i = 0; i < accounts.length; i++) {
            list.add(new EditableAccount(accounts[i]));
        }
        System.out.println("running");
        return list;

    }    
}


