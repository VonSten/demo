package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class bankService {
    @Autowired
    private bankRepository bankRepository;


    public void createCustomer(@RequestBody Customer customer) {
        if (!bankRepository.checkForCustomer(customer)) {
            bankRepository.createCustomer(customer);
        }

    }

    public void createAccount(Customer customer){
        Integer id = bankRepository.getCustomerId(customer);
        bankRepository.insertNewAccount(customer, id);

    }


    public  String depositMoney(Action deposit){

        if(deposit.getSum().intValue() <=0){
            return "saast";
        }
        BigDecimal balance = bankRepository.getBalance(deposit);
        BigDecimal newBalance = balance.add(deposit.getSum());

        bankRepository.updateBalance(deposit, newBalance);

        deposit.setAccountTo(deposit.getAccount());
        bankRepository.updateHistory(deposit);

        return deposit.getSum().toString() + " RSD was added to account: " + deposit.getAccount();

    }

    public String getBalance(Action action){

        return bankRepository.getBalance(action).toString();
    }

    public void withdraw(Action withdraw){
        if(withdraw.getSum().intValue() >0 && bankRepository.getBalance(withdraw).compareTo(withdraw.getSum()) > 0){

            BigDecimal newBalance = bankRepository.getBalance(withdraw).subtract(withdraw.getSum());
            bankRepository.updateBalance(withdraw, newBalance);
        }

        withdraw.setAccountTo(withdraw.getAccount());
        withdraw.setSum(withdraw.getSum().negate());
        bankRepository.updateHistory(withdraw);

    }

    public void transfer(Action transfer){

        if(bankRepository.getBalance(transfer).compareTo(transfer.getSum()) >= 0 && transfer.getSum().intValue() >0 ) {

            BigDecimal newFromBalance = bankRepository.getBalance(transfer).subtract(transfer.getSum());
            bankRepository.updateBalance(transfer, newFromBalance);
            Action transferTo = new Action();
            transferTo.setAccount(transfer.getAccountTo());


            BigDecimal newToBalance = bankRepository.getBalance(transferTo).add(transfer.getSum());
            bankRepository.updateBalance(transferTo, newToBalance);
            bankRepository.updateHistory(transfer);

        }
    }



}