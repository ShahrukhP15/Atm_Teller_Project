package model;

import exceptions.NotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Collection of Accounts

public class AllAccounts implements Writable {

    private ArrayList<Account> accounts;

    //EFFECTS: Constructs AllAccounts with a list of Accounts
    public  AllAccounts() {
        accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }


    // MODIFIES: this
    // EFFECTS: Adds new account to list of accounts
    public Account addAccount(String username, String password) {
        Account account = new Account(username,password);
        accounts.add(account);
        EventLog.getInstance().logEvent(new Event("Account added with username " + account.getUsername()
                + " to the list of accounts"));
        return account;
    }

    // EFFECTS: looks up Account with username and password,returns account if found,throws NotFoundException otherwise
    public Account lookupAccount(String username, String password) throws NotFoundException {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                EventLog.getInstance().logEvent(new Event("Logged into account with username " + username
                        + " from the list of accounts"));
                return account;
            }
        }
        EventLog.getInstance().logEvent(new Event("Wrong account input"));
        throw new NotFoundException();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("accounts",accountToJson());
        return json;
    }

    // EFFECTS: returns account in AllAccounts as a JSON array
    private JSONArray accountToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Account a : accounts) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }
}


