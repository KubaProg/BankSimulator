package Bank;

import AdditionalClasses.ChangeLineInFile;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class TransferManager {

    Scanner scanner = new Scanner(System.in);
    private String fileName = "accountInfo.csv";

    ChangeLineInFile lineEditor = new ChangeLineInFile();

    public void depositeMoney(Optional<Account> account){
        double currentBalance = account.get().getBalance();
        account.get().setBalance(currentBalance+=askHowMuchToDeposite());
        saveTransferChangesToCsvFile(account,account.get().getAccountNumber());
    }

    public void withdrawMoney(Optional<Account> account){
        takeTransferDataFromUser();

    }

    public void saveTransferChangesToCsvFile(Optional<Account> account,int accountId){
        double balanceAfterTranser = account.get().getBalance();
        int currentLineNumber=0;
        try(
                var fileWriter = new FileWriter(fileName,true);
                var bufferedWriter = new BufferedWriter(fileWriter);

                var fileReader = new FileReader(fileName);
                var bufferedReader = new BufferedReader(fileReader);
                ) {
            String currentLine = null;
            while((currentLine = bufferedReader.readLine())!=null){
                currentLineNumber++;
                String[] splitedLine = currentLine.split(",");
                int currentId = Integer.parseInt(splitedLine[1]);
                if(currentId==accountId){
                    lineEditor.changeALineInATextFile(fileName, balanceAfterTranser+","+accountId+","+splitedLine[2]+","+splitedLine[3],currentLineNumber);
                }
            }
        }
        catch (IOException e) {
            System.err.println("There hasn't been found the file called: " + fileName);
        }

    }

    public void takeTransferDataFromUser(){
        System.out.println("Enter the account id that you want to send money to: ");
        int id = scanner.nextInt();
        System.out.println("Enter the amount of money you want to send: ");
        double amountOfMoneytoSend = scanner.nextDouble();
    }

    public double askHowMuchToDeposite(){
        System.out.println("How much money you want to deposite to your account: ");
        double deposite = scanner.nextDouble();
        return deposite;
    }


}
