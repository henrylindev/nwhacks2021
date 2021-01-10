package nehacks.backend.account;

public class EditableAccount extends Account {
    
    private boolean editable = false;
    private boolean deletable = false;

    public EditableAccount() {
        super();
    }
    
    public EditableAccount(Account a) {
        super(a.getID(), a.getName(), a.getAmount());
    }
    
    public EditableAccount(String id, String name, double amount) {
        super(id, name, amount);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }
    
}
