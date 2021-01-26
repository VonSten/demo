package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank")
@RestController


public class Bankcontroller {

    @Autowired
    private bankService service;

    @PostMapping("createcustomer")
    public void createAcc(@RequestBody Customer customer) {
        service.createCustomer(customer);
    }


    @PostMapping("createacc")
    public void createAccount(@RequestBody Customer customer) {
        service.createAccount(customer);
    }

    @PutMapping("deposit")
    public void deposit(@RequestBody Deposit deposit) {
        service.depositMoney(deposit);
    }

    @GetMapping("balance")
    public String getBalance(@RequestBody Balance balance) {

        return service.getBalance(balance);
    }

    @PutMapping("withdraw")
    public void withdraw(@RequestBody Withdraw withdraw) {
        service.withdraw(withdraw);
    }

    @PutMapping("transfer")
    public void transfer(@RequestBody Transfer transfer) {
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