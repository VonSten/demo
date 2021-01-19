package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("bank")
@RestController



public class lesson4controller {
@GetMapping()

public String start(){
    return "Welcome to bank" + "\n" + "enter help for help";
    }

@GetMapping("help")
public String help(){
    return Lesson4web.help();
}

@GetMapping("createaccount")
    public String createaccount(){
 return   Lesson4web.createAccount();
}

@GetMapping("deposit")

public String dep(){

    return "Insert account nr and sum to deposit";
   }

@GetMapping("deposit/{a}/{b}")

public String deposit(@PathVariable("a") String account, @PathVariable("b") double input){
    BigDecimal deposit = new BigDecimal(input);
    return Lesson4web.depositMoney(account, deposit);
}

    @GetMapping("balance")
    public String bal(){

        return "enter account nr";
    }

@GetMapping("balance/{a}")
 public String balance(@PathVariable("a") String balance){

    return Lesson4web.getBalance(balance);
}

    @GetMapping("withdraw")
    public String with(){

        return "Insert account nr and sum to deposit to withdraw";
    }


    @GetMapping("withdraw/{a}/{b}")

    public String withdraw(@PathVariable("a") String account, @PathVariable("b") Double input){
         BigDecimal inputz = BigDecimal.valueOf(input)  ;
        return Lesson4web.withdrawMoney(account, inputz);
    }
    @GetMapping("transfer")
    public String trans(){

        return "Insert accounts and sum to deposit to withdraw";
    }


    @GetMapping("transfer/{a}/{b}/{c}")

    public String transfer(@PathVariable("a") String account, @PathVariable("b") String accountto, @PathVariable("c")BigDecimal sum){

        return Lesson4web.transfermoney(account,accountto,sum);
    }




}
