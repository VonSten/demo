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


    public  String depositMoney(Deposit deposit){

        if(deposit.getSum().intValue() <=0){
            return "saast";
        }
        BigDecimal balance = bankRepository.getBalance(deposit.getAccount());
        BigDecimal newBalance = balance.add(deposit.getSum());

        bankRepository.updateBalance(deposit.getAccount(), newBalance);


        bankRepository.updateHistory(deposit.getAccount(), deposit.getAccount(), deposit.getSum());

        return deposit.getSum().toString() + " RSD was added to account: " + deposit.getAccount();

    }

    public String getBalance(Balance action){

        return bankRepository.getBalance(action.getAccount()).toString();
    }



    public void withdraw(Withdraw withdraw){
        if(withdraw.getSum().intValue() >0 && bankRepository.getBalance(withdraw.getAccount()).compareTo(withdraw.getSum()) > 0){

            BigDecimal newBalance = bankRepository.getBalance(withdraw.getAccount()).subtract(withdraw.getSum());
            bankRepository.updateBalance(withdraw.getAccount(), newBalance);
        }


        bankRepository.updateHistory(withdraw.getAccount(), withdraw.getAccount(), withdraw.getSum().negate());

    }

    public void transfer(Transfer transfer){

        if(bankRepository.getBalance(transfer.getAccountFrom()).compareTo(transfer.getSum()) >= 0 && transfer.getSum().intValue() >0 ) {

            BigDecimal newFromBalance = bankRepository.getBalance(transfer.getAccountFrom()).subtract(transfer.getSum());
            bankRepository.updateBalance(transfer.getAccountFrom(), newFromBalance);


            BigDecimal newToBalance = bankRepository.getBalance(transfer.getAccountTo()).add(transfer.getSum());
            bankRepository.updateBalance(transfer.getAccountTo(), newToBalance);

            bankRepository.updateHistory(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getSum());

        }
    }



}