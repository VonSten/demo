package ee.bcs.valiit.tasks.dto;

import java.math.BigDecimal;

public class Deposit {
    private Integer account;
    private BigDecimal sum;

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Deposit() {
    }

    public Deposit(Integer account, BigDecimal sum) {
        this.account = account;
        this.sum = sum;
    }
}
