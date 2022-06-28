import Bank.Account;
import Bank.AccountDataBase;
import Bank.ControlLoop;
import ClientSection.ClientDataBase;

public class BankingApp {
    public static void main(String[] args) {

        ClientDataBase clientDataBase = new ClientDataBase();
        AccountDataBase accountDataBase = new AccountDataBase();
        ControlLoop controlLoop = new ControlLoop();


        controlLoop.menuLoop();


    }
}
