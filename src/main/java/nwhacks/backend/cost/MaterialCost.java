package nwhacks.backend.cost;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class MaterialCost extends Cost{
    
    private String materialName;

    public MaterialCost() {
        super();
    }

    public MaterialCost(UUID costId, UUID projectId, Date date, BigDecimal amount, boolean inJournal, String materialName) {
        super(costId, projectId, date, amount, inJournal);
        this.materialName = materialName;
    }

    protected String getMaterialName() {
        return materialName;
    }

    protected void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

}
