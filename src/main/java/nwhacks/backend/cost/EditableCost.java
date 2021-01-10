package nwhacks.backend.cost;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class EditableCost extends Cost {
    
    private boolean editable = false;
    private boolean deletable = false;

    public EditableCost() {
        super();
    }
    
    public EditableCost(UUID costId, UUID projectId, Date date, BigDecimal amount, boolean inJournal) {
        super(costId, projectId, date, amount, inJournal);
    }
    
    public EditableCost(Cost c) {
        super(c.getCostId(), c.getProjectId(), c.getDate(), c.getAmount(), c.isInJournal());
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
