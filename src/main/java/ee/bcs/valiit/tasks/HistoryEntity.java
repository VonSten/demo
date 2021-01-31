package ee.bcs.valiit.tasks;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="history")

public class HistoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="to_acc")
    private Integer toAccount;

    @Column(name="from_acc")
    private Integer fromAccount;

    public Integer getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Integer fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Column(name = "time_tr")
    private String timeTr;

    @Column(name = "date_tr")
    private String  dateTr;

    @Column(name = "sum_tr")
    private BigDecimal sumTr;

    @Column(name = "transfer_type")
    private String transferType;

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Column(name = "receiver")
    private String receiver;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccount = toAccount;
    }

    public String getTimeTr() {
        return timeTr;
    }

    public void setTimeTr(String timeTr) {
        this.timeTr = timeTr;
    }

    public String getDateTr() {
        return dateTr;
    }

    public void setDateTr(String dateTr) {
        this.dateTr = dateTr;
    }

    public BigDecimal getSumTr() {
        return sumTr;
    }

    public void setSumTr(BigDecimal sumTr) {
        this.sumTr = sumTr;
    }

    public HistoryEntity() {

    }
}
