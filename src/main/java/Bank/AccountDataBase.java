package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDataBase {

   static List<Account> clientAccounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

   public void addAccount(Double balance, int accountNumber, String login, String password){
       Account account = new Account(balance,accountNumber,login,password);
       clientAccounts.add(account);
   }

    public List<Account> getClientAccounts() {
        return clientAccounts;
    }

    public static void setClientAccounts(List<Account> clientAccounts) {
        AccountDataBase.clientAccounts = clientAccounts;
    }

    public Account getClientByAccNum(int id){
        Account account = new Account();
        for (Account clientAccount : clientAccounts) {
            if(clientAccount.getAccountNumber()==id){
                account = clientAccount;
            }
        }
        return account;
    }

    public Account makeAccountForClient(){
        System.out.println("Enter the account balance: ");
        double balance = scanner.nextDouble();

        System.out.println("Enter the account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the login to the new account: ");
        String login = scanner.nextLine();

        System.out.println("Enter the password to the new account: ");
        String password = scanner.nextLine();
        scanner.nextLine();

        return new Account(balance,accountNumber, login, password);
    }

    public Account getAccountByAccountNumber(int accNumber){

       Account properAccont = new Account();

        for (Account clientAccount : clientAccounts) {
            if(clientAccount.getAccountNumber()==accNumber){
                properAccont = clientAccount;
            }
        }
       return properAccont;
    }

}
