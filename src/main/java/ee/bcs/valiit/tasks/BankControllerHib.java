package ee.bcs.valiit.tasks;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("bankhib")
@RestController


public class BankControllerHib {

    @Autowired
    private BankServiceHib service;
    ModelMapper mapper = new ModelMapper();

    @PostMapping("createcustomer")
    public Customer createAcc(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createCustomer(customersEntity);
        Customer returnCustomer = new Customer();
        returnCustomer.setFirstName(customer.getFirstName());
        returnCustomer.setLastname(customer.getLastName());
        return returnCustomer;
    }


    @PostMapping("createaccount")
    public CreatedAccount createAccount(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createAccount(customersEntity);
        return new CreatedAccount(customer.getFirstName(), customer.getLastName(), service.accountNumberByOwner(customer));
    }



    @PutMapping("deposit")
    public Deposit deposit (@RequestBody Deposit deposit) throws BankExeption {
        service.depositMoney(deposit);
        return new Deposit(deposit.getAccount(),deposit.getSum());
    }

    @PostMapping("balance")

    public  Balance balance(@RequestBody Balance balance) throws BankExeption {
        return new Balance(balance.getAccount(), service.getBalance(balance));
    }




    @PutMapping("withdraw")
    public Withdraw withdraw(@RequestBody Withdraw withdraw) throws BankExeption {
        service.withdraw(withdraw);
        return new Withdraw(withdraw.getAccount(), withdraw.getSum());
    }

    @PutMapping("transfer")
    public Transfer transfer(@RequestBody Transfer transfer) throws BankExeption {
        service.transfer(transfer);
        return new Transfer(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getSum());

    }


    @GetMapping("history")
    public List<HistoryEntity>  getHistory(@RequestBody Balance balance){
        return service.getHistory(balance.getAccount());
    }

}