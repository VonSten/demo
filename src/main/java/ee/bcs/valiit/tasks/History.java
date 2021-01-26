package ee.bcs.valiit.tasks;

import java.math.BigDecimal;


public class History {


    private Integer id;
    private Integer from_acc;
    private Integer to_acc;
    private String date_tr;
    private String time_tr;
    private BigDecimal sum_tr;
    private String transferType;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom_acc() {
        return from_acc;
    }

    public void setFrom_acc(Integer from_acc) {
        this.from_acc = from_acc;
    }

    public Integer getTo_acc() {
        return to_acc;
    }

    public void setTo_acc(Integer to_acc) {
        this.to_acc = to_acc;
    }

    public String getDate_tr() {
        return date_tr;
    }

    public void setDate_tr(String date_tr) {
        this.date_tr = date_tr;
    }

    public String getTime_tr() {
        return time_tr;
    }

    public void setTime_tr(String time_tr) {
        this.time_tr = time_tr;
    }

    public BigDecimal getSum_tr() {
        return sum_tr;
    }

    public void setSum_tr(BigDecimal sum_tr) {
        this.sum_tr = sum_tr;
    }
}
