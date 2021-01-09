package nwhacks.backend.employee;

public class Account {

    private String ID;
    private String name;
    private double amount;
    
    public Account() {
        super();
    }

    public Account(String iD, String name, double amount) {
        super();
        ID = iD;
        this.name = name;
        this.amount = amount;
    }
    
    public void debit(double x) {
        amount += x;
    }
    
    public void credit(double x) {
        amount -= x;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
