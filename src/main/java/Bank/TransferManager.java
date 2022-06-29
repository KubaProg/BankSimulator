package Bank;

import AdditionalClasses.ChangeLineInFile;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class TransferManager {

    Scanner scanner = new Scanner(System.in);
    private String fileName = "accountInfo.csv";

    private int id;
    private double amountOfMoneytoSend;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmountOfMoneytoSend() {
        return amountOfMoneytoSend;
    }

    public void setAmountOfMoneytoSend(double amountOfMoneytoSend) {
        this.amountOfMoneytoSend = amountOfMoneytoSend;
    }

    public ChangeLineInFile getLineEditor() {
        return lineEditor;
    }

    public void setLineEditor(ChangeLineInFile lineEditor) {
        this.lineEditor = lineEditor;
    }

    ChangeLineInFile lineEditor = new ChangeLineInFile();

    public void depositeMoney(Optional<Account> account){
        double currentBalance = account.get().getBalance();
        account.get().setBalance(currentBalance+=askHowMuchToDeposite());
        saveTransferChangesToCsvFile(account,0);
    }

    public void transferMoney(Optional<Account> account){
        takeTransferDataFromUser();
        double currentBalance = account.get().getBalance();
        account.get().setBalance(currentBalance-=getAmountOfMoneytoSend());
        saveTransferChangesToCsvFile(account,getId());
    }

    public void saveTransferChangesToCsvFile(Optional<Account> account, int accountToTransferId){
        double balanceAfterTranser;
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
                double currentBalance = Double.parseDouble(splitedLine[0]);
              if(accountToTransferId==0) // Deposit
              {
                  if (currentId == account.get().getAccountNumber()) {
                      balanceAfterTranser = account.get().getBalance();
                      lineEditor.changeALineInATextFile(fileName, balanceAfterTranser + "," + account.get().getAccountNumber() + "," + splitedLine[2] + "," + splitedLine[3], currentLineNumber);
                  }
              }else if(getId()!=account.get().getAccountNumber())  // Transfer from account to account
              {
                  if (currentId == account.get().getAccountNumber()) {
                      balanceAfterTranser = account.get().getBalance();
                      lineEditor.changeALineInATextFile(fileName, balanceAfterTranser + "," + account.get().getAccountNumber() + "," + splitedLine[2] + "," + splitedLine[3], currentLineNumber);
                  }
                  if (currentId == accountToTransferId) {
                      balanceAfterTranser = currentBalance+=getAmountOfMoneytoSend();
                      lineEditor.changeALineInATextFile(fileName, balanceAfterTranser + "," + accountToTransferId + "," + splitedLine[2] + "," + splitedLine[3], currentLineNumber);
                  }
              }
              else{
                  System.err.println("You can't transfer money from your account to your accout. You should choose deposite option");
                  break;
              }
            }
        }
        catch (IOException e) {
            System.err.println("There hasn't been found the file called: " + fileName);
        }
    }

    public void takeTransferDataFromUser(){
        System.out.println("Enter the account id that you want to send money to: ");
        setId(scanner.nextInt());
        System.out.println("Enter the amount of money you want to send: ");
        setAmountOfMoneytoSend(scanner.nextDouble());
    }


    public double askHowMuchToDeposite(){
        System.out.println("How much money you want to deposite to your account: ");
        double deposite = scanner.nextDouble();
        return deposite;
    }


}
