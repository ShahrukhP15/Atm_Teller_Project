package model;

import exceptions.NotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

//Collection of Accounts

public class AllAccounts  {

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
        return account;
    }

    // EFFECTS: looks up Account with username and password,returns account if found,throws NotFoundException otherwise
    public Account lookupAccount(String username, String password) throws NotFoundException {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
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


