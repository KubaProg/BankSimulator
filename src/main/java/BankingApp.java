import Bank.Account;
import Bank.AccountDataBase;
import Bank.ControlLoop;
import ClientSection.ClientDataBase;

public class BankingApp {
    public static void main(String[] args) {

        ClientDataBase clientDataBase = new ClientDataBase();
        AccountDataBase accountDataBase = new AccountDataBase();
        ControlLoop controlLoop = new ControlLoop();

        accountDataBase.addAccount(1500.0,123, "log1", "pas1");
        accountDataBase.addAccount(2500.0,876, "log2", "pas2");
        accountDataBase.addAccount(45000.0,342, "log3", "pas3");

        clientDataBase.addClient("Piotrek","Kwieciński",40,1, accountDataBase.getClientByAccNum(876));
        clientDataBase.addClient("Piotrek","Sanda",44,2, accountDataBase.getClientByAccNum(123));
        clientDataBase.addClient("Piotrek","Olej",41,3, accountDataBase.getClientByAccNum(342));

        controlLoop.menuLoop();

    }
}
