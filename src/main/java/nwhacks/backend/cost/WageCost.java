package nwhacks.backend.cost;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class WageCost extends Cost {
    
    private UUID empId;

    public WageCost() {
        super();
    }
    
    public WageCost(UUID costId,UUID projectId, Date date, BigDecimal amount, boolean inJournal, UUID empID) {
        super(costId, projectId, date, amount, inJournal);
    }

    public WageCost(UUID projectId, Date date, BigDecimal amount, boolean inJournal, UUID empID) {
        super(projectId, date, amount, inJournal);
        this.empId = empID;
    }

    protected UUID getEmpId() {
        return empId;
    }

    protected void setEmpId(UUID empId) {
        this.empId = empId;
    }
        
}
