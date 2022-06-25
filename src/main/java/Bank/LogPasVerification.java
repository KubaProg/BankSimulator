package Bank;

import java.util.Scanner;

public class LogPasVerification {

    private String login;
    private String password;

    Scanner scanner = new Scanner(System.in);

public int verifyClientsAccountByLogAndPass() {
    int accountNumber = 0;
    boolean isWrongData = true;

    while (isWrongData)
    {
        takeDataFromUser();
    if (login.equals("log1") && password.equals("pas1")) {
        accountNumber = 123;
        isWrongData=false;
        System.out.println("Succesfuly logged in!");
        printClientsMenu();
    } else if (login.equals("log2") && password.equals("pas2")) {
        accountNumber = 876;
        isWrongData=false;
        System.out.println("Succesfuly logged in!");
        printClientsMenu();
    } else if (login.equals("log3") && password.equals("pas3")) {
        isWrongData=false;
        accountNumber = 342;
        System.out.println("Succesfuly logged in!");
        printClientsMenu();
    } else {
        System.out.println("Wrong login and/or password");
    }
}
    return accountNumber;

}



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
        System.out.print("Podaj login: ");
        login = scanner.nextLine();
        System.out.println();
        System.out.print("Podaj haslo: ");
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
