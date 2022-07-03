package Bank;

import java.util.Scanner;

public class LogPasVerification {

    private String login;
    private String password;

    Scanner scanner = new Scanner(System.in);

    public void verifyAdminsAccountByLogAndPass(){
        boolean isWrongData = true;
        while(isWrongData) {
            takeDataFromUser();

            if (login.equals("admin") && password.equals("admin")) {
                System.out.println("Succesfuly logged in!");
                isWrongData = false;
            } else {
                System.out.println("Wrong login and/or password");
            }
        }
    }

    public void takeDataFromUser(){
        System.out.print("Enter login(admin): ");
        login = scanner.nextLine();
        System.out.println();
        System.out.print("Enter haslo(admin): ");
        password = scanner.nextLine();
    }

    public void printClientsMenu(){

        System.out.print("Client's menu: \n" +
                "1. Check Balance \n" +
                "2. Exchange money \n" +
                "3. Transfer \n" +
                "4. Exit Client's account \n");

    }

}
