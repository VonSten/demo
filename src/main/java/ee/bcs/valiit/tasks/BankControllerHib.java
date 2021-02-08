package ee.bcs.valiit.tasks;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import liquibase.pro.packaged.C;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequestMapping("bankhib")
@RestController


public class BankControllerHib {

    @Autowired
    private BankServiceHib service;
    ModelMapper mapper = new ModelMapper();

    @CrossOrigin
    @PostMapping("login")

    public String login(@RequestBody LoginCredentials loginCredentials){
        if(validate(loginCredentials.getUsername(), loginCredentials.getPassword())) {
            Date now = new Date();
            Date expiration = new Date(now.getTime() + 1000 * 60 * 60);
            JwtBuilder builder = Jwts.builder()
                    .setExpiration(expiration)
                    .setIssuedAt(now)
                    .setIssuer("sten")
                    .signWith(SignatureAlgorithm.HS256, "cGFzc3dvcmQ=")
                    .claim(loginCredentials.getUsername(), loginCredentials.getPassword());
            return builder.compact();
        }
        return "error";
    }
@Autowired
private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;

    public boolean validate(String userName, String rawPassword){
        UserDetailServiceIMpl udsi = new UserDetailServiceIMpl();
        String encodedPassword = udsi.loadUserByUsername(userName).getPassword();
        return passwordEncoder.matches(rawPassword, encodedPassword);

    }



    @CrossOrigin
    @PostMapping("createcustomer")
    public Customer createAcc(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createCustomer(customersEntity);
        Customer returnCustomer = new Customer();
        returnCustomer.setFirstName(customer.getFirstName());
        returnCustomer.setLastname(customer.getLastName());
        return returnCustomer;
    }

    @CrossOrigin
    @PostMapping("createaccount")
    public CreatedAccount createAccount(@RequestBody Customer customer) throws BankExeption {
        CustomersEntity customersEntity = mapper.map(customer, CustomersEntity.class);
        service.createAccount(customersEntity);
        return new CreatedAccount(customer.getFirstName(), customer.getLastName(), service.accountNumberByOwner(customer));
    }


    @CrossOrigin
    @PutMapping("deposit")
    public Deposit deposit (@RequestBody Deposit deposit) throws BankExeption {
        service.depositMoney(deposit);
        return new Deposit(deposit.getAccount(),deposit.getSum());
    }
    @CrossOrigin
    @PostMapping("balance")

    public  Balance balance(@RequestBody Balance balance) throws BankExeption {
        return new Balance(balance.getAccount(), service.getBalance(balance));
    }



    @CrossOrigin
    @PutMapping("withdraw")
    public Withdraw withdraw(@RequestBody Withdraw withdraw) throws BankExeption {
        service.withdraw(withdraw);
        return new Withdraw(withdraw.getAccount(), withdraw.getSum());
    }
    @CrossOrigin
    @PutMapping("transfer")
    public Transfer transfer(@RequestBody Transfer transfer) throws BankExeption {
        service.transfer(transfer);
        return new Transfer(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getSum());

    }

    @CrossOrigin
    @PostMapping("history")
    public List<HistoryEntity>  getHistory(@RequestBody Balance balance){
        return service.getHistory(balance.getAccount());
    }

}