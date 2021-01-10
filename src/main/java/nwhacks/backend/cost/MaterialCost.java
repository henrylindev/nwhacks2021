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
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="materialcost")
@Named("materialCost")
@SessionScoped
public class MaterialCost implements Serializable {
    
    @Column(name="materialname")
    private String materialName;

    public MaterialCost() {
        super();
    }

    public MaterialCost(UUID costId, UUID projectId, Date date, BigDecimal amount, boolean inJournal, String materialName) {
            super();
            this.costId = UUID.randomUUID();
            this.projectId = projectId;
            this.date = date;
            this.amount = amount;
            this.inJournal = inJournal;
    }

    protected String getMaterialName() {
        return materialName;
    }

    protected void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    
    @Id
    @Column(name="materialcostid")
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

}
