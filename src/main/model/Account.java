package model;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import org.json.JSONObject;
import persistence.Writable;

//Making an account to withdraw, deposit and check balance
public class Account  implements Writable {

    private int balance;
    private String username;
    private String password;


    //EFFECTS: creates an account with a string username and string password
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //MODIFIES: this
    //EFFECTS: sets the balance to given balance
    public void setBalance(int balance) {
        this.balance = balance;
    }

    //MODIFIES: this
    //EFFECTS: adds amount cents to balance on account
    public int deposit(int amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException();
        }
        balance = balance + amount;
        EventLog.getInstance().logEvent(new Event("Amount deposited in account with username " + this.getUsername() +
                ": " + amount));
        return balance;
    }

    //MODIFIES: this
    //EFFECTS: if there is sufficient balance on the account
    //    //            - subtracts amount cents from balance
    //    //            - returns true
    //    //               otherwise, returns false
    public int withdraw(int amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException();
        }
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }
        balance = balance - amount;
        EventLog.getInstance().logEvent(new Event("Amount withdrawn from account with username " + this.getUsername()
                + ": " + amount));
        return balance;
    }

    //EFFECTS: returns the current balance in cents;
    public int getBalance() {
        return balance;
    }



    // EFFECTS: returns the current username
    public String getUsername() {
        return username;
    }



    //EFFECTS: returns the current password
    public String getPassword() {
        return password;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        json.put("balance", balance);
        return json;
    }
}
