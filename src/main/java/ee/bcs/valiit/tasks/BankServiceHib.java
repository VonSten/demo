package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class BankServiceHib {
    @Autowired
    private HistoryRepo historyRepo;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private AccountsRepo accountsRepo;
    String negSum = "Sum is negative! ";


    public void createCustomer(CustomersEntity customer) throws BankExeption {
        if(!customersRepository.findCustomersEntityByFirstNameAndLastName(customer.getFirstName(), customer.getLastName()).isEmpty()){
            throw new BankExeption ("Customer exists");
        }
        else{
            customersRepository.save(customer);
        }
    }
    public void createAccount(CustomersEntity customer) throws BankExeption {
        List<CustomersEntity> l = customersRepository.findCustomersEntityByFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
        if(l.isEmpty()){
            throw new BankExeption("Customer not found");
        }
        else {
            AccountsEntity account = new AccountsEntity();
            account.setBalance(BigDecimal.valueOf(0));
            account.setOwner(customersRepository.findCustomersEntityByFirstNameAndLastName(customer.getFirstName(), customer.getLastName()).get(0).getId());
            accountsRepo.save(account);
        }
    }

    public void depositMoney(Deposit deposit) throws BankExeption {
        if (deposit.getSum().intValue() <= 0) {
            throw new BankExeption(negSum);
        }
        AccountsEntity accountsEntity = accountsRepo.getOne(deposit.getAccount());
        accountsEntity.setBalance(accountsEntity.getBalance().add(deposit.getSum()));
        accountsRepo.flush();
        setHistory(deposit.getAccount(), deposit.getAccount(), deposit.getSum());
    }


    public BigDecimal getBalance(Balance balance) throws BankExeption {
        if(accountsRepo.findAccountsEntityById(balance.getAccount()).isEmpty()){
            throw new BankExeption("Account does not exist");
        }
        else{
            return accountsRepo.findAccountsEntityById(balance.getAccount()).get(0).getBalance();
        }

    }


    public void withdraw(Withdraw withdraw) throws BankExeption {
        AccountsEntity accountsEntity = accountsRepo.getOne(withdraw.getAccount());
        if(withdraw.getSum().intValue() <0 || accountsRepo.getOne(withdraw.getAccount()).getBalance().compareTo(withdraw.getSum()) < 0 ){
            if(withdraw.getSum().intValue() < 0 ){
                throw new BankExeption(negSum);
            }
            else {
                throw new BankExeption("Not enough funds");
            }
        }
        accountsEntity.setBalance(accountsEntity.getBalance().subtract(withdraw.getSum()));
        accountsRepo.flush();
        setHistory(withdraw.getAccount(),withdraw.getAccount(), withdraw.getSum().negate());
    }



    public void transfer(Transfer transfer) throws BankExeption {
        AccountsEntity accountsEntityFrom = accountsRepo.getOne(transfer.getAccountFrom());
        AccountsEntity accountsEntityTo = accountsRepo.getOne(transfer.getAccountTo());


        if (accountsEntityFrom.getBalance().compareTo(transfer.getSum()) <= 0 || transfer.getSum().intValue() < 0 || transfer.getAccountTo().equals(transfer.getAccountFrom())) {
            if(transfer.getSum().intValue() < 0){
                throw new BankExeption(negSum);
            }
            else if(transfer.getAccountTo().equals(transfer.getAccountFrom())){
                throw  new BankExeption("Illegal transaction");
            }
            throw new BankExeption("Not enough funds");
        }
        else{

            accountsEntityFrom.setBalance(accountsEntityFrom.getBalance().subtract(transfer.getSum()));
            accountsEntityTo.setBalance(accountsEntityTo.getBalance().add(transfer.getSum()));
            accountsRepo.flush();
            setHistory(transfer.getAccountTo(), transfer.getAccountFrom(), transfer.getSum());
        }
    }

    public void  setHistory(Integer accountTo, Integer accountFrom, BigDecimal sum){
        HistoryEntity history = new HistoryEntity();
        history.setToAccount(accountTo);
        history.setFromAccount(accountFrom);
        history.setDateTr(LocalDate.now().toString());
        history.setTimeTr(LocalTime.now().toString());
        history.setSumTr(sum);
        AccountsEntity to = accountsRepo.getOne(accountTo);
        history.setReceiver(customersRepository.getOne(to.getOwner()).getFirstName() + " " + customersRepository.getOne(to.getOwner()).getLastName());

        if(accountTo.equals(accountFrom) && sum.intValue() < 0){
            history.setTransferType("Withdraw");
        }
        else if(accountTo.equals(accountFrom) && sum.intValue() > 0){
            history.setTransferType("Deposit");
        }
        else {
            history.setTransferType("Transfer");
        }
        historyRepo.save(history);

    }

    public List<HistoryEntity> getHistory(Integer account){

        return   historyRepo.findHistoryEntityByFromAccountOrToAccount(account,account);


    }

    public Integer accountNumberByOwner(Customer customer){
       Integer owner =   customersRepository.findCustomersEntityByFirstNameAndLastName(customer.getFirstName(), customer.getLastName()).get(0).getId();
      return accountsRepo.findAccountsEntityByOwnerOrderByIdDesc(owner).get(0).getId();

    }

}