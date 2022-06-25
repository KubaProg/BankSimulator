package ClientSection;

import Bank.Account;
import Bank.AccountDataBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientDataBase {

    static List<Client> clients = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    AccountDataBase accountDataBase = new AccountDataBase();

    public  List<Client> getClients() {
        return clients;
    }

    public void addClient(String name, String surName, int age, int Id, Account account){
        Client client = new Client(name,surName,age,Id, account);
        clients.add(client);
    }

    public void makeAndAddClient(){
        System.out.println("Client's name: ");
        String name = scanner.nextLine();
        System.out.println("Client's surname: ");
        String surName = scanner.nextLine();
        System.out.println("Client's age: ");
        int age = scanner.nextInt();
        System.out.println("Client's id: ");
        int id = scanner.nextInt();

        Account newAccount = accountDataBase.makeAccountForClient();

     addClient(name,surName,age,id, newAccount);
    }

    public void printClients(){
        for (Client client : clients) {
            System.out.println(client);
            System.out.println();
        }
    }

    public void searchForClientById()
    {
        System.out.print("Podaj ID: ");
        int id = scanner.nextInt();

        for (Client client : clients) {
            if(client.getId()==id)
            {
                System.out.println(client);
            }
        }
    }

}
