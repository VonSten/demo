package ee.bcs.valiit.tasks;

import java.math.BigDecimal;

public class Transfer {
    private Integer accountFrom;
    private Integer accountTo;
    private BigDecimal sum;

    public Integer getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Integer accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Integer getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Integer accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }


    public Transfer(Integer accountFrom, Integer accountTo, BigDecimal sum) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.sum = sum;
    }
}
