package ee.bcs.valiit.tasks.dto;

import java.math.BigDecimal;

public class Account {
    private int id;
    private BigDecimal balance;
    private int owner;


    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setOwner(int owwner) {
        this.owner = owwner;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getOwner() {
        return owner;
    }
}
