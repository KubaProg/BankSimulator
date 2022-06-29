package Bank;

import ClientSection.ClientDataBase;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class ControlLoop {

    private static Scanner scanner = new Scanner(System.in);

    ClientDataBase clientDataBase = new ClientDataBase();
    AccountDataBase accountDataBase = new AccountDataBase();
    LogPasVerification logPasVerification = new LogPasVerification();
    Account account = new Account();
    Exchange exchange = new Exchange();
     private int choice;
     boolean exitOrNot=true;

     public void menuLoop()
     {
         while(exitOrNot) {
             printInitialMenu();
             initialChoiceChecker();
         }
     }

    public void initialChoiceChecker(){
       try {
           choice = scanner.nextInt();

           switch (choice) {
               case 1 ->{
                   Optional<Account> properAccount = accountDataBase.veryfiClientsAccountByLogAndPass();
                   printClientsMenu();
                   clientsChoiceChecker(properAccount);
               }
               case 2 -> {
                   logPasVerification.verifyAdminsAccountByLogAndPass();
                   printAdminsMenu();
                   adminsChoiceChecker();
               }
               case 3 -> {
                   exitOrNot = false;
                   System.out.println(" See you next time! ");
               }
               default -> System.out.println("There is no option like this! Must be 1-3");
           }
       }catch(InputMismatchException e){
           System.err.println("There is not option like this! Must be 1-3");
       }
    }

    public void adminsChoiceChecker()
    {
        boolean exitOrNotForAdminsMenu = true;
        while(exitOrNotForAdminsMenu) {
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> clientDataBase.printClients();
                    case 2 -> clientDataBase.makeAndAddClient();
                    case 3 -> clientDataBase.searchForClientById();
                    case 4 -> exitOrNotForAdminsMenu = false;
                }
                printAdminsMenu();
            } catch (InputMismatchException e) {
                System.err.println("There is not option like this! Must be 1-3");
            }
        }
    }

    public void clientsChoiceChecker(Optional<Account> account)
    {
        boolean exitOrNotForClientsMenu = true;
        while(exitOrNotForClientsMenu) {
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> System.out.println(account.get().getBalance());
                    case 2 -> exchangeMenu();
                    case 3 -> {
                        transferMenu();
                        transferChoiceChecker(account);
                    }
                    case 4 -> exitOrNotForClientsMenu = false;
                }
                printClientsMenu();
            } catch (InputMismatchException e) {
                System.err.println("There is not option like this! Must be 1-3");
            }
        }
    }

    public void transferChoiceChecker(Optional<Account> account){
         TransferManager transferManager = new TransferManager();
        System.out.println("Option: ");
        int option = scanner.nextInt();
        switch(option) {
            case 1 -> transferManager.depositeMoney(account);
            case 2 -> transferManager.transferMoney(account);
        }
    }

    public void printInitialMenu(){
             System.out.println("Welcome! ");
             System.out.println("MENU: (choose the option between 1-3)");
             System.out.print("1. Log in as Client \n" +
                     "2. Log in as Admin \n" +
                     "3. Exit the bank \n" +
                     "Option: ");
    }

    public void printClientsMenu(){

             System.out.print("Client's menu: \n" +
                     "1. Check Balance \n" +
                     "2. Exchange money (not ready) \n" +
                     "3. Transfer \n" +
                     "4. Exit Client's account \n");

    }

    public void printAdminsMenu() {
            System.out.print("Admins's menu: \n" +
                    "1. Check clients list (saved in file): \n" +
                    "2. Add Client \n" +
                    "3. Search for client by ID \n" +
                    "4. Exit Admin's account \n");
    }

    public void exchangeMenu(){
        System.out.print("Exchange menu: \n" +
                "1. Convert from EUR -> PLN \n" +
                "2. Convert from PLN -> EUR \n" +
                "3. Convert from DOL to PLN \n" +
                "4. Convert from PLN to DOL \n" +
                "5. Convert from EUR to DOL \n" +
                "6. Convert from DOL to EUR \n"
        );
    }

    public void transferMenu(){
        System.out.print("Transfer menu: \n" +
                "1. Deposit to your account \n" +
                "2. Make a transfer \n"
        );
    }

}
