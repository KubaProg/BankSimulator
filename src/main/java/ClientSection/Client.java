package ClientSection;

import Bank.Account;

public class Client {

private String name;
private String surname;
private int age;
private int id;
private Account account;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Client(String name, String secondName, int age, int id, Account account) {
        this.name = name;
        this.surname = secondName;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public Client(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return surname;
    }

    public void setSurnameName(String secondName) {
        this.surname = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
}

    public int getId(){
        return id;
        }

        public void setId(int id){
        this.id=id;
        }

    @Override
    public String toString() {
        return "Client's info: " + "\n"
                + "Name: " + name + "\n"
                + "LastName: " + surname + "\n"
                + "Age: " + age + "\n"
                + "Id: " + id + "\n"
                + "Account's  number: " + account.getAccountNumber() + "\n"
                + "Account's balance: " + account.getBalance();
    }
}
