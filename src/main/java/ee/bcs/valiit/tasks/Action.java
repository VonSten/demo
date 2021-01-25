package ee.bcs.valiit.tasks;

import java.math.BigDecimal;

public class Action {
    private  Integer account;
    private Integer accountTo;
    private  BigDecimal sum;

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

    public Integer getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Integer accountTo) {
        this.accountTo = accountTo;
    }
}
