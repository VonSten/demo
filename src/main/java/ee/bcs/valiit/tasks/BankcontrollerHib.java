package ee.bcs.valiit.tasks;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("bankhib")
@RestController


public class BankcontrollerHib {

    @Autowired
    private BankServiceHib service;
    ModelMapper mapper = new ModelMapper();

    @PostMapping("createcustomer")
    public ResponseEntity<String> createAcc(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createCustomer(customersEntity);
        return new  ResponseEntity<>("Customer created: " + customer.getFirstName() + " " + customer.getLastName(), HttpStatus.CREATED);
    }

    @PostMapping("createaccount")
    public ResponseEntity<String> createAccount(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createAccount(customersEntity);
        return  new ResponseEntity<>("Account created for:  " + customer.getFirstName() + " " + customer.getLastName(), HttpStatus.CREATED);
    }



    @PutMapping("deposit")
    public ResponseEntity<String> deposit (@RequestBody Deposit deposit) throws BankExeption {
        service.depositMoney(deposit);
        return new ResponseEntity<>(deposit.getSum().toString() + " deposited to account : " + deposit.getAccount(), HttpStatus.OK);
    }

    @GetMapping("balance")

    public  ResponseEntity<String> balance(@RequestBody Balance balance) throws BankExeption {
        return new ResponseEntity<>("Balance of account:" + balance.getAccount() + " is " + service.getBalance(balance) ,HttpStatus.OK);
    }




    @PutMapping("withdraw")
    public ResponseEntity<String> withdraw(@RequestBody Withdraw withdraw) throws BankExeption {
        service.withdraw(withdraw);

        return new ResponseEntity<>(withdraw.getSum().toString() + " is withdrawn from account: " + withdraw.getAccount(), HttpStatus.OK);
    }

    @PutMapping("transfer")
    public ResponseEntity<String> transfer(@RequestBody Transfer transfer) throws BankExeption {

        service.transfer(transfer);

        return  new ResponseEntity<>(
                transfer.getSum() + "is transferred from account: " + transfer.getAccountFrom() + " to account: " + transfer.getAccountTo()
                ,HttpStatus.OK
        );

    }




    @GetMapping("history")
    public List<HistoryEntity>  getHistory(@RequestBody Balance balance){
     return service.getHistory(balance.getAccount());
    }

}