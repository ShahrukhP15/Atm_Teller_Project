package model;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidException;
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
    public int deposit(int amount) throws InvalidException {
        if (amount < 0) {
            EventLog.getInstance().logEvent(new Event("Invalid amount entered"));
            throw new InvalidException();
        }
        balance = balance + amount;
        EventLog.getInstance().logEvent(new Event("Amount deposited in account with username "
                + this.getUsername() + ": " + amount));
        return balance;
    }

    //MODIFIES: this
    //EFFECTS: if there is sufficient balance on the account
    //    //            - subtracts amount cents from balance
    //    //            - returns true
    //    //               otherwise, returns false
    public int withdraw(int amount) throws InvalidException, InsufficientBalanceException {
        if (amount < 0) {
            EventLog.getInstance().logEvent(new Event("Invalid amount entered"));
            throw new InvalidException();
        }
        if (amount > balance) {
            EventLog.getInstance().logEvent(new Event("Tried to withdraw more than balance in account"));
            throw new InsufficientBalanceException();
        }
        balance = balance - amount;
        EventLog.getInstance().logEvent(new Event("Amount withdrawn from account with username "
                + this.getUsername() + ": " + amount));
        return balance;
    }

    //EFFECTS: returns the current balance in cents;
    public int getBalance() {
        EventLog.getInstance().logEvent(new Event("Current balance of account with username "
                 + this.getUsername() + ": " + balance));
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
        EventLog.getInstance().logEvent(new Event("Account information saved"));
        return json;
    }
}
