package ee.bcs.valiit.tasks;

import java.math.BigDecimal;

public class Balance {
    private Integer account;
    BigDecimal sum;


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

    public Balance(Integer account, BigDecimal sum) {
        this.account = account;
        this.sum = sum;
    }
}



