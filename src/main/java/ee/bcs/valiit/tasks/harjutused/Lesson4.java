package ee.bcs.valiit.tasks.harjutused;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    private static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();
    static Long accountNr = 1L;


    public static void main(String[] args) {
        System.out.println("Type help to begin!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ( line.equalsIgnoreCase("exit") ) {
                break;
            }

            //getBalance
         else   if ( line.equalsIgnoreCase("getBalance") ) {

                System.out.println("Enter account nr:");
                line = scanner.nextLine();
                if ( !accountBalanceMap.containsKey(line) ) {
                    System.out.println("Account not found!");
                }


                System.out.println("Account balance of account:" + getBalance(line));
                System.out.println(accountBalanceMap.get(line));
            }

            // create account
           else if ( line.equalsIgnoreCase("createAccount") ) {
                createAccount();
            }

           else if ( line.equalsIgnoreCase("depositMoney") ) {
                    try {
                        System.out.println("Insert account nr");
                        String account = scanner.nextLine();
                        if ( !accountBalanceMap.containsKey(account) ) {
                            System.out.println("Account not found");
                        }

                        System.out.println("Insert sum to deposit:");

                        line = scanner.nextLine();


                        BigDecimal deposit = new BigDecimal(line);
                        if ( deposit.intValue() <= 0 ) {

                            System.out.println("Invalid sum");
                        }


                        depositMoney(account, deposit);
                        System.out.println("Sum of: " + deposit.toString() + " added to account: " + account);

                    } catch (NumberFormatException e) {
                        System.out.println("not a number - try again");
                        line = scanner.nextLine();
                    }
                }

        else if ( line.equalsIgnoreCase("withDrawMoney") ) {
                System.out.println("Insert account: ");
                String account = scanner.nextLine();
                if ( !accountBalanceMap.containsKey(account) ) {
                    System.out.println("Account does not exist!");
                } else {
                    System.out.println("insert sum");
                    BigDecimal withd = new BigDecimal(scanner.nextLine());
                    withdrawMoney(account, withd);

                    System.out.println("Remaining balance is:" + accountBalanceMap.get(account).toString());
                }

            }

        else if ( line.equalsIgnoreCase("transferMoney") ) {
                System.out.println("Insert accounts FROM and TO you want to transfer and the SUM");

                String[] input = scanner.nextLine().split(" ");
                BigDecimal transfer = new BigDecimal(input[ 2 ]);

                if ( getBalance(input[ 0 ]).compareTo(transfer) >= 0 && accountBalanceMap.containsKey(input[ 0 ]) && accountBalanceMap.containsKey(input[ 1 ]) ) {
                    withdrawMoney(input[ 0 ], transfer);
                    depositMoney(input[ 1 ], transfer);

                    System.out.println("Sum of: " + input[ 2 ] + " transfered from " + " account: " + input[ 0 ] + " to account: " + input[ 2 ]);
                }

                else {
                    System.out.println("ERROR");
                }

            }


            //help
          else if ( line.equalsIgnoreCase("help") ) {

                System.out.println("creteaccount      Creates new account.");
                System.out.println("getbalance        displays balance of an account.");

                System.out.println("depositmoney      deposit money to account");
                System.out.println("withdrawmoney     withdraw money from account");
                System.out.println("transfermoney     transfer money from account to another account");
                System.out.println("exit              exits program.");
            }


            else {
                System.out.println("Unknown command");
            }


        }
    }


    // Add command: "depositMoney ${accountNr} ${amount}
    // this has to add specified amount of money to account
    // You have to check that amount is positive number
    public static void depositMoney(String account, BigDecimal input) {

        accountBalanceMap.put(account, ( accountBalanceMap.get(account).add(input) ));
    }


    // Creates new account with the balance of 0
    public static void createAccount() {

        accountBalanceMap.put(String.valueOf(accountNr), BigDecimal.ZERO);
        System.out.println("Account nr: " + accountNr + " created!!!");

        accountNr++;
    }

    // getBalance meetod

    public static BigDecimal getBalance(String input) {

        return accountBalanceMap.get(input);
    }
    //withdraw money

    public static void withdrawMoney(String account, BigDecimal input) {

        if ( getBalance(account).compareTo(input) >= 0 && input.floatValue() > 0 ) {
            accountBalanceMap.put(account, accountBalanceMap.get(account).subtract(input));

        } else {
            System.out.println("not enough funds");
        }

    }

    public static void transferMoney() {


    }

}


