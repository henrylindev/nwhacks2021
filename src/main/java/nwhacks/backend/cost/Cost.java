package nwhacks.backend.cost;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.InheritanceType;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Table(name="cost")
@Named("cost")
@SessionScoped
public class Cost implements Serializable {

    @Id
    @Column(name="materialcostid")
    @Type(type = "uuid-char")
     private UUID costId;
     
    @Column(name="projectid")
     private UUID projectId;
     
    @Column(name="costdate")
     private Date date;
     
    @Column(name="costamount")
     private BigDecimal amount;
     
    @Column(name="injournal")
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
    
    protected void setCostId(UUID costId) {
        this.costId = costId;
    }

    protected UUID getProjectId() {
        return projectId;
    }

    protected void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

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
