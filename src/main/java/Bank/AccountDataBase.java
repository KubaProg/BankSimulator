package Bank;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AccountDataBase {

   static List<Account> clientAccounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String fileName = "accountInfo.csv";

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

    public String[] askClientForLogAndPas(){
           System.out.println("Enter login: ");
           String login = scanner.nextLine();
           System.out.println("Enter password: ");
           String password = scanner.nextLine();
           String[] tab = {login, password};
            return tab;
    }

    public Optional<Account> veryfiClientsAccountByLogAndPass(){
       boolean test = true;
while(test){
        String[] logAndPasTab = askClientForLogAndPas();
        String login = logAndPasTab[0];
        String password = logAndPasTab[1];;

        try(
                var fileReader = new FileReader(fileName);
                var bufferedReader = new BufferedReader(fileReader);
                ) {
            String currentLine = null;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] separatedData = currentLine.split(",");
                if (password.equals(separatedData[2]) && login.equals(separatedData[3])) {
                    test = false;
                    double balance = Double.parseDouble(separatedData[0]);
                    int accountNumber = Integer.parseInt(separatedData[1]);
                    Account properAccount = new Account(balance, accountNumber, password, login);
                    return Optional.of(properAccount);
                }
            }
            System.err.println("Wrong login or password");
        }
        catch (IOException e) {
            System.out.println("Problem z plikiem: " + fileName);
        }
        }
        return Optional.empty();
    }

    public void showClientsBalance(Account account)      {
        System.out.println(account.getBalance());
    }

}
