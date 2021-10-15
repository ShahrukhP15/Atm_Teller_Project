package model;

//Making an account to withdraw, deposit and check balance
public class Account {

    private int balance;
    private String username;
    private int password;



    //REQUIRES: initialBalance >=0
    //EFFECTS: constructs an account with given initial balance in cents
    public Account(int initialBalance) {
        this.balance = initialBalance;
    }


    //REQUIRES: amount > 0
    //MODIFIES: this
    //EFFECTS: adds amount cents to balance on account
    public void deposit(int amount) {
        balance = balance + amount;
    }

    //MODIFIES: this
    //EFFECTS: if there is sufficient balance on the account
    //    //            - subtracts amount cents from balance
    //    //            - returns true
    //    //               otherwise, returns false
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn");
            return  true;
        } else {
            System.out.println("Insufficient Balance");
            return false;
        }
    }

    //EFFECTS: returns the current balance in cents;
    public int getBalance() {
        return balance;
    }

    //MODIFIES: this
    //EFFECTS: sets username to given username
    public void setUsername(String username) {
        this.username = username;
    }


    // EFFECTS: returns the current username
    public String getUsername() {
        return username;
    }

    //EFFECTS: sets password to given password
    public void setPassword(int password) {
        this.password = password;
    }


    //EFFECTS: returns the current password
    public int getPassword() {
        return password;
    }
}
