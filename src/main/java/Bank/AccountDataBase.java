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
        System.out.println("Podaj balans konta nowego klienta: ");
        double balance = scanner.nextDouble();

        System.out.println("Podaj numer konta nowego klienta: ");
        int accountNumber = scanner.nextInt();

        System.out.println("Podaj login do konta nowego klienta: ");
        String login = scanner.nextLine();

        System.out.println("Podaj haslo do konta nowego klienta: ");
        String password = scanner.nextLine();

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
