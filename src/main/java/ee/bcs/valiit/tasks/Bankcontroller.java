package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("bank")
@RestController



public class Bankcontroller {

    @Autowired
    private bankService service;



    @PostMapping("createcustomer")
    public void createAcc(@RequestBody  Customer customer){
        service.createCustomer(customer);
    }


    @PostMapping("createacc")
    public void createAccount(@RequestBody Customer customer) {
        service.createAccount(customer);
    }

    @PutMapping("deposit")
    public void deposit(@RequestBody Action deposit) {
        service.depositMoney(deposit);
    }

    @GetMapping("balance")
    public String getBalance(@RequestBody Action balance){

        return   service.getBalance(balance);
    }

    @PutMapping ("withdraw")
    public void withdraw(@RequestBody Action withdraw){
        service.withdraw(withdraw);
    }

    @PutMapping("transfer")
    public void transfer(@RequestBody Action transfer){
        service.transfer(transfer);

    }



}