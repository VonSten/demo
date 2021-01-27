package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    String negSum = "Sum is negative";

    public void createCustomer(Customer customer) throws BankExeption {
        if(bankRepository.checkForCustomer(customer)){
            throw new BankExeption ("Customer exists");
        }
        else{
            bankRepository.createCustomer(customer);}
        }


@Transactional
    public void createAccount(Customer customer) throws EmptyResultDataAccessException, BankExeption {
       try {
           bankRepository.getCustomerId(customer);
       }
       catch(EmptyResultDataAccessException e) {
           throw new BankExeption("Customer not found");
        }

        Integer id = bankRepository.getCustomerId(customer);
        bankRepository.insertNewAccount(id);

    }

@Transactional
    public String depositMoney(Deposit deposit) throws BankExeption {

        if (deposit.getSum().intValue() <= 0) {
            throw new BankExeption(negSum);
        }
        BigDecimal balance = bankRepository.getBalance(deposit.getAccount());
        BigDecimal newBalance = balance.add(deposit.getSum());

        bankRepository.updateBalance(deposit.getAccount(), newBalance);


        bankRepository.updateHistory(deposit.getAccount(), deposit.getAccount(), deposit.getSum());

        return deposit.getSum().toString() + " RSD was added to account: " + deposit.getAccount();

    }
@Transactional
    public String getBalance(Balance action) throws BankExeption {
        try {
            bankRepository.getBalance(action.getAccount()).toString();
        }
        catch (EmptyResultDataAccessException e){
            throw new BankExeption("Account does not exist");
        }
        return bankRepository.getBalance(action.getAccount()).toString();
    }


@Transactional
    public void withdraw(Withdraw withdraw) throws BankExeption {
        if (withdraw.getSum().intValue() < 0 || bankRepository.getBalance(withdraw.getAccount()).compareTo(withdraw.getSum()) < 0){
             if(withdraw.getSum().intValue() < 0 ){
                 throw new BankExeption(negSum);
             }
             else {
                 throw new BankExeption("Not enough funds");
             }
        }
        else {
            BigDecimal newBalance = bankRepository.getBalance(withdraw.getAccount()).subtract(withdraw.getSum());
            bankRepository.updateBalance(withdraw.getAccount(), newBalance);
            bankRepository.updateHistory(withdraw.getAccount(), withdraw.getAccount(), withdraw.getSum().negate());
        }
    }




@Transactional
    public void transfer(Transfer transfer) throws BankExeption {

        if (bankRepository.getBalance(transfer.getAccountFrom()).compareTo(transfer.getSum()) <= 0 || transfer.getSum().intValue() < 0 || transfer.getAccountTo().equals(transfer.getAccountFrom())) {
          if(transfer.getSum().intValue() < 0){
              throw new BankExeption(negSum);
          }
          else if(transfer.getAccountTo().equals(transfer.getAccountFrom())){
              throw  new BankExeption("Illegal transaction");
            }
             throw new BankExeption("Not enough funds");
        }
           else{
            BigDecimal newFromBalance = bankRepository.getBalance(transfer.getAccountFrom()).subtract(transfer.getSum());
            bankRepository.updateBalance(transfer.getAccountFrom(), newFromBalance);


            BigDecimal newToBalance = bankRepository.getBalance(transfer.getAccountTo()).add(transfer.getSum());
            bankRepository.updateBalance(transfer.getAccountTo(), newToBalance);

            bankRepository.updateHistory(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getSum());

        }
    }
  public List<History> getHistory(Integer input){

        return bankRepository.accountHistory(input);

  }

}