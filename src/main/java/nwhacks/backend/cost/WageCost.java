package nwhacks.backend.cost;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="wagecost")
@Named("wageCost")
@SessionScoped
public class WageCost implements Serializable {
    
    @Column(name="empid")
    @Type(type = "uuid-char")
    private UUID empId;
    
    @Id
    @Column(name="costid")
    @Type(type = "uuid-char")
     private UUID costId;
     
    @Column(name="projectid")
    @Type(type = "uuid-char")
     private UUID projectId;
     
    @Column(name="costdate")
     private Date date;
     
    @Column(name="costamount")
     private BigDecimal amount;
     
    @Column(name="injournal")
     private boolean inJournal;
     
     

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

    public WageCost() {
        super();
    }
    
    
    
//    public WageCost(UUID costId,UUID projectId, Date date, BigDecimal amount, boolean inJournal, UUID empID) {
//        super(costId, projectId, date, amount, inJournal);
//    }
//
//    public WageCost(UUID projectId, Date date, BigDecimal amount, boolean inJournal, UUID empID) {
//        super(projectId, date, amount, inJournal);
//        this.empId = empID;
//    }

    public WageCost(UUID empId, UUID costId, UUID projectId, Date date, BigDecimal amount, boolean inJournal) {
        super();
        this.empId = empId;
        this.costId = costId;
        this.projectId = projectId;
        this.date = date;
        this.amount = amount;
        this.inJournal = inJournal;
    }

    protected UUID getEmpId() {
        return empId;
    }

    protected void setEmpId(UUID empId) {
        this.empId = empId;
    }
        
}
