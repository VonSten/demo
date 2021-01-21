package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    static int accountNumber = 10001;


    private List<String> history = new ArrayList();
    private BigDecimal balance = new BigDecimal(String.valueOf(0));
    public BigDecimal input = new BigDecimal(0);


    public  int getAccountNumber() {
        return accountNumber;
    }



    public List<String> getHistory() {
        return history;
    }

    public void setHistory(String input) {
        this.history = history;
        history.add(input);
    }


    public static void setAccountNumber() {
        Account.accountNumber ++;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInput() {
        return input;
    }
}
