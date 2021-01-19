package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("bank2")
@RestController



public class lesson4controller2 {


    private static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();
    static Long accountNr = 1L;

    @GetMapping()

    public String start(){
        return "Welcome to bank" + "\n" + "enter help for help";
    }


    @GetMapping("help")


    public static String help() {
        StringBuilder sb = new StringBuilder();
        sb.append("creteaccount      Creates new account." + "\n");
        sb.append("getbalance        displays balance of an account." + "\n");
        sb.append("depositmoney      deposit money to account" + "\n");
        sb.append("withdrawmoney     withdraw money from account" + "\n");
        sb.append("transfermoney     transfer money from account to another account" + "\n");
        sb.append("exit              exits program." + "\n");

        return sb.toString();
    }


    @GetMapping("createaccount")
    // Creates new account with the balance of 0
    public static String createAccount() {

        accountBalanceMap.put(String.valueOf(accountNr), BigDecimal.ZERO);
        String ret = "Account nr: " + accountNr + " created!!!";
        accountNr++;
        return ret;
    }
    @GetMapping("deposit")

    public String dep(){

        return "Insert account nr and sum to deposit";
    }


    @GetMapping("deposit/{a}/{b}")

    public static String deposit(@PathVariable("a") String account, @PathVariable("b") BigDecimal input)

    {


        if ( input.intValue() <= 0 ) {

            return "Invalid sum";
        }

        if ( !accountBalanceMap.containsKey(account) ) {
            return "Account not found";
        }

        accountBalanceMap.put(account, ( accountBalanceMap.get(account).add(input) ));

        return "Sum of: " + input.toString() + " added to account: " + account;

    }

    @GetMapping("balance")
    public String bal(){

        return "enter account nr";
    }


    @GetMapping("balance/{a}")
    public String balance(@PathVariable("a") String input){



        if ( !accountBalanceMap.containsKey(input) ) {
            return "Account not found!";
        }
        return "Account balance of account" + input + " : " + accountBalanceMap.get(input).toString();
    }


    @GetMapping("withdraw")
    public String with(){

        return "Insert account nr and sum to deposit to withdraw";
    }



    @GetMapping("withdraw/{a}/{b}")

    public static String withdraw(@PathVariable("a") String account, @PathVariable("b") BigDecimal input){




        String ret = "";
        if ( !accountBalanceMap.containsKey(account) ) {
            return "Account does not exist!";}

            if ( accountBalanceMap.get(account).compareTo(input) >= 0 && input.floatValue() > 0 ) {

                accountBalanceMap.put(account, accountBalanceMap.get(account).subtract(input));

                ret = input.toString() + " was withdrawn from " + account + " new balance is: " + accountBalanceMap.get(account);
            }
            else {
                return "not enough funds";
            }


        return ret;
    }

    @GetMapping("transfer")
    public String trans(){

        return "Insert accounts and sum to deposit to withdraw";
    }



    @GetMapping("transfer/{a}/{b}/{c}")

    public static String transfer(@PathVariable("a") String accountfrom, @PathVariable("b") String accountto, @PathVariable("c")BigDecimal transfer){



    if ( !accountBalanceMap.containsKey(accountfrom) || !accountBalanceMap.containsKey(accountto) ) {
        return "account not found";
    }

    if ( accountBalanceMap.get(accountfrom).compareTo(transfer) <= 0 ) {
        return "not enough funds";

    } else {
        accountBalanceMap.put(accountfrom, accountBalanceMap.get(accountfrom).subtract(transfer));
        accountBalanceMap.put(accountto, accountBalanceMap.get(accountto).add(transfer));


        return transfer.toString() + " transfered from " + accountfrom + " to " + accountto;

    }
}


}
