package ClientSection;

import Bank.Account;
import Bank.AccountDataBase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientDataBase {

    static List<Client> clients = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    AccountDataBase accountDataBase = new AccountDataBase();
    String fileName = "clientsList.csv";

    public  List<Client> getClients() {
        return clients;
    }

    public void addClient(String name, String surName, int age, int Id, int accountNumber){
        Client client = new Client(name,surName,age,Id, accountNumber);
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
        System.out.println("Client's account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        try {
            saveClient(name,surName,age,id, accountNumber);
        } catch (IOException e) {
            System.out.println("Brak pliku o nazwie: " + fileName);
        }
    }

    public void saveClient(String name, String surname, int age,int id, int accountNumber) throws IOException {
        try(
                var fileWriter = new FileWriter(fileName,true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                ){
            bufferedWriter.write(name +","+surname+","+age+","+id+","+accountNumber);
            bufferedWriter.newLine();
        }
    }

    public void deleteClient(){
        File inputFile = new File("clientsList.csv");
        File tempFile = new File("myTempFile.csv");

        System.out.println("Client's to delete id: ");
        String id = scanner.nextLine();

        try(
                var reader = new BufferedReader(new FileReader(inputFile));
                var writer = new BufferedWriter(new FileWriter(tempFile));
                ){
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String[] splitedLine = currentLine.split(",");
                String currentClientsId = splitedLine[3];
                if(currentClientsId.equals(id)) continue;
                writer.write(currentLine);
                writer.newLine();
            }
        }catch(IOException e){
            System.err.println("There is no file: " + inputFile.getName() + " or " + tempFile.getName());
        }

        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
    }

    public void printClients(){

        try
                (var fileReader = new FileReader(fileName);
                 var bufferedReader = new BufferedReader(fileReader);
            )
        {
            String currentClientInfoLine=null;

            while((currentClientInfoLine = bufferedReader.readLine()) != null){
                String preparedToPrintClientsInfo = createClientsInfoFromCsvLine(currentClientInfoLine);
                System.out.println(preparedToPrintClientsInfo);
            }


        } catch (IOException e) {
            System.out.println("Brak pliku o nazwie: " + fileName);
        }

    }

    public String createClientsInfoFromCsvLine(String csvLine){
        String[] separatedClientData = csvLine.split(",");
        String fullInfo = "Name: " + separatedClientData[0] + "\n"
                + "Surname: " + separatedClientData[1] + "\n"
                + "Age: " + separatedClientData[2] + "\n"
                + "Id: " + separatedClientData[3] + "\n"
                + "Account number: " + separatedClientData[4] + "\n";

        return fullInfo;
    }

    public void searchForClientById()
    {
        System.out.print("Podaj ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        fromCsvToClientsList(fileName);

        for (Client client : clients) {
            if(client.getId()==id)
            {
                System.out.println(client);
            }
        }
    }

    public void fromCsvToClientsList(String fileName){
        try(
                var fileReader = new FileReader(fileName);
                var bufferedReader = new BufferedReader(fileReader);
                ){
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null){
                clients.add(returnClientFromRawData(currentLine));
            }

        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku o nazwie: " + fileName);
        }
    }

    public Client returnClientFromRawData(String currentLine){
        String[] splitedClientsData = currentLine.split(",");
       String name = splitedClientsData[0];
        String surname = splitedClientsData[1];
        int age = Integer.parseInt(splitedClientsData[2]);
        int id = Integer.parseInt(splitedClientsData[3]);
        int accountNumber = Integer.parseInt(splitedClientsData[4]);
        return new Client(name,surname,age,id,accountNumber);
    }

}
