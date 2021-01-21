package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@RequestMapping("bank")
@RestController



public class bankcontroller {


    private static HashMap<Integer, Account> bankMap = new HashMap<>();

    @GetMapping()

    public String start(){ return "Welcome to bank" + "\n" + "enter help for help";
    }


    @GetMapping("help")

    public String help() {
        StringBuilder sb = new StringBuilder();
        sb.append("creteaccount      Creates new account." + "\n");
        sb.append("getbalance        displays balance of an account." + "\n");
        sb.append("depositmoney      deposit money to account" + "\n");
        sb.append("withdrawmoney     withdraw money from account" + "\n");
        sb.append("transfermoney     transfer money from account to another account" + "\n");

        return sb.toString();
    }


    @PostMapping("createaccount")

    public String  createAccount() {
        Account acc = new Account();
        bankMap.put(acc.getAccountNumber(), acc);
        acc.setHistory("account created: " +java.time.LocalDate.now().toString());
        Account.setAccountNumber();
    return "account " + acc.getAccountNumber() + " created";
    }


    @GetMapping("history")

    public List<String> history(@RequestParam ("a") Long account){
        return    bankMap.get(account).getHistory();
    }




    @PostMapping("deposit")

    public static String deposit(@RequestBody int accountnr, String sum)

    {


        BigDecimal input = new BigDecimal(sum);
        if ( input.intValue() <= 0 ) {
            return "Invalid sum";
        }

        if ( !bankMap.containsKey(accountnr) ) {
            return "Account not found";
        }

        bankMap.get(accountnr).setBalance(input);

        return "Sum of: " + input.toString() + " added to account: " + accountnr;

    }




//    @GetMapping("balance")
//    public String bal(){
//
//        return "enter account nr";
//    }
//
//
//    @GetMapping("balance/{a}")
//    public String balance(@PathVariable("a") String input){
//
//
//
//        if ( !accountBalanceMap.containsKey(input) ) {
//            return "Account not found!";
//        }
//        return "Account balance of account" + input + " : " + accountBalanceMap.get(input).toString();
//    }
//
//
//    @GetMapping("withdraw")
//    public String with(){
//
//        return "Insert account nr and sum to deposit to withdraw";
//    }
//
//
//
//    @GetMapping("withdraw/{a}/{b}")
//
//    public static String withdraw(@PathVariable("a") String account, @PathVariable("b") BigDecimal input){
//
//
//
//
//        String ret = "";
//        if ( !accountBalanceMap.containsKey(account) ) {
//            return "Account does not exist!";}
//
//        if ( accountBalanceMap.get(account).compareTo(input) >= 0 && input.floatValue() > 0 ) {
//
//            accountBalanceMap.put(account, accountBalanceMap.get(account).subtract(input));
//
//            ret = input.toString() + " was withdrawn from " + account + " new balance is: " + accountBalanceMap.get(account);
//        }
//        else {
//            return "not enough funds";
//        }
//
//
//        return ret;
//    }
//
//    @GetMapping("transfer")
//    public String trans(){
//
//        return "Insert accounts and sum to deposit to withdraw";
//    }
//
//
//
//    @GetMapping("transfer/{a}/{b}/{c}")
//
//    public  String transfer(@PathVariable("a") String accountfrom, @PathVariable("b") String accountto, @PathVariable("c")BigDecimal transfer){
//
//
//
//        if ( !accountBalanceMap.containsKey(accountfrom) || !accountBalanceMap.containsKey(accountto) ) {
//            return "account not found";
//        }
//
//        if ( accountBalanceMap.get(accountfrom).compareTo(transfer) <= 0 ) {
//            return "not enough funds";
//
//        } else {
//            accountBalanceMap.put(accountfrom, accountBalanceMap.get(accountfrom).subtract(transfer));
//            accountBalanceMap.put(accountto, accountBalanceMap.get(accountto).add(transfer));
//
//
//            return transfer.toString() + " transfered from " + accountfrom + " to " + accountto;
//
//        }
//    }


}
