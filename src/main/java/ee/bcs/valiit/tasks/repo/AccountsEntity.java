package ee.bcs.valiit.tasks.repo;

import ee.bcs.valiit.tasks.repo.CustomersEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="accounts")
public class AccountsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer owner;

    private BigDecimal balance;


    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomersEntity customersEntity;

    public AccountsEntity() {
         // standard constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CustomersEntity getCustomersEntity() {
        return customersEntity;
    }

    public void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }


}
