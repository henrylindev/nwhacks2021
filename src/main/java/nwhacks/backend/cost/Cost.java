package nwhacks.backend.cost;

import java.math.BigDecimal;
import java.util.Date;

import java.util.UUID;

public class Cost {

     private UUID costId;
     
     private UUID projectId;
     
     private Date date;
     
     private BigDecimal amount;
     
     private boolean inJournal;
     
     public Cost() {
         super();
         
     }
     
     public Cost(UUID costId, UUID projectId, Date date, BigDecimal amount, boolean inJournal) {
         super();
     }
     
    public Cost(UUID projectId, Date date, BigDecimal amount, boolean inJournal) {
        super();
        this.costId = UUID.randomUUID();
        this.projectId = projectId;
        this.date = date;
        this.amount = amount;
        this.inJournal = inJournal;
    }




    protected UUID getCostId() {
        return costId;
    }
//    
//    protected void setCostId(UUID costId) {
//        this.costId = costId;
//    }

    protected UUID getProjectId() {
        return projectId;
    }

//    protected void setProjectId(UUID projectId) {
//        this.projectId = projectId;
//    }

    protected Date getDate() {
        return date;
    }

    protected void setDate(Date date) {
        this.date = date;
    }

    protected BigDecimal getAmount() {
        return amount;
    }

    protected void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    protected boolean isInJournal() {
        return inJournal;
    }

    protected void setInJournal(boolean inJournal) {
        this.inJournal = inJournal;
    }

}
