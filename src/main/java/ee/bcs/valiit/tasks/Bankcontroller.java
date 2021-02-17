package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank")
@RestController


public class Bankcontroller {

    @Autowired
    private BankService service;

    @PostMapping("createcustomer")
    public void createAcc(@RequestBody Customer customer) throws BankExeption {
        service.createCustomer(customer);

    }


    @PostMapping("createacc")
    public void createAccount(@RequestBody Customer customer) throws BankExeption {
        service.createAccount(customer);
    }

    @PutMapping("deposit")
    public void deposit(@RequestBody Deposit deposit) throws BankExeption {
        service.depositMoney(deposit);
    }

    @GetMapping("balance")
    public String getBalance(@RequestBody Balance balance) throws BankExeption {

        return service.getBalance(balance);
    }

    @PutMapping("withdraw")
    public void withdraw(@RequestBody Withdraw withdraw) throws BankExeption {
        service.withdraw(withdraw);
    }

    @PutMapping("transfer")
    public void transfer(@RequestBody Transfer transfer) throws BankExeption {
        service.transfer(transfer);

    }
    @GetMapping("history")
    public String  getHistory(@RequestBody Balance balance){
     List<History> ret = service.getHistory(balance.getAccount());
     StringBuilder sb = new StringBuilder();
     for(History h : ret){
         sb.append(h.getTime_tr() + " " + h.getDate_tr() + " " + h.getTransferType() + " " + h.getName() + " " + h.getSum_tr() + "\n");
     }
     return  sb.toString();
    }

}