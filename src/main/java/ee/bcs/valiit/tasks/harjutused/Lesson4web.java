package ee.bcs.valiit.tasks.harjutused;


import java.math.BigDecimal;
import java.util.HashMap;

public class Lesson4web {
    private static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();
    static Long accountNr = 1L;


    public static void main(String[] args) {

//                    System.out.println("ERROR");

//                System.out.println("Unknown command");

    }

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

    // Creates new account with the balance of 0
    public static String createAccount() {

        accountBalanceMap.put(String.valueOf(accountNr), BigDecimal.ZERO);
        String ret = "Account nr: " + accountNr + " created!!!";
        accountNr++;
        return ret;
    }

    public static String depositMoney(String account, BigDecimal input) {


        if ( input.intValue() <= 0 ) {

            return "Invalid sum";
        }

        if ( !accountBalanceMap.containsKey(account) ) {
            return "Account not found";
        }

        accountBalanceMap.put(account, ( accountBalanceMap.get(account).add(input) ));

        return "Sum of: " + input.toString() + " added to account: " + account;

    }


    public static String getBalance(String input) {
        if ( !accountBalanceMap.containsKey(input) ) {
            return "Account not found!";
        }
        return "Account balance of account" + input + " : " + accountBalanceMap.get(input).toString();
    }


    public static String withdrawMoney(String account, BigDecimal input) {
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

public static String transfermoney(String accountfrom, String accountto, BigDecimal transfer) {
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
