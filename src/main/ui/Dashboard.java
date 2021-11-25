package ui;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import exceptions.NotFoundException;
import model.Account;
import model.AllAccounts;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// A Dashboard for user to interact and give inputs
public class Dashboard {
    private boolean runProgram = true;
    private Scanner input;
    private AllAccounts accounts;
    private static final String JSON_STORE = "./data/data.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: Constructs new Dashboard
    public Dashboard() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        accounts = new AllAccounts();
        input = new Scanner(System.in);
        loadAccountsData();
        runDashboard();
    }

    //EFFECTS: runs the program
    private void runDashboard() {
        while (runProgram) {
            System.out.println("Username: ");
            String username = getUserInputString();
            System.out.println("Password: ");
            String password = getUserInputString();
            try {
                Account currentAccount = accounts.lookupAccount(username,password);
                System.out.println("Account found! Type Commands");
                printInstructions();
                mainMenuInput(currentAccount);
            } catch (NotFoundException e) {
                System.out.println("Account not found! Create new Account? [y/n]");
                String text = getUserInputString();
                if (text.equals("Y")  || text.equals("y")) {
                    createNewAccount();
                }
            }

        }
    }

    //EFFECTS: creates a new Account
    private void createNewAccount() {
        System.out.println("Create New User");
        System.out.println("Username: ");
        String username = getUserInputString();
        System.out.println("Password: ");
        String password = getUserInputString();
        accounts.addAccount(username,password);
        System.out.println("Account successfully created. Login to continue");
    }



    // MODIFIES: this
    // EFFECTS: prints menu options and info depending on input str
    private void mainMenuInput(Account account) {
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            String str = getUserInputString();
            switch (str) {
                case "1":
                    withdrawal(account);
                    break;
                case "2":
                    deposit(account);
                    break;
                case "3":
                    System.out.println("Your current balance is " + account.getBalance());
                    break;
                default:
                    isLoggedIn = furtherCases(str);
                    break;
            }
            printInstructions();
        }
    }


    //EFFECTS: the further options in the menu
    public boolean furtherCases(String str) {
        boolean loggedCondition = true;
        switch (str) {
            case "4":
                System.out.println("Logged out!");
                loggedCondition = false;
                break;
            case "5":
                loggedCondition = false;
                quit();
                break;
        }
        return loggedCondition;
    }


    //EFFECTS: takes an amount and withdraws that amount of money from the account
    public void withdrawal(Account account) {
        int amount;
        System.out.println("Enter Amount you want to withdraw");
        amount = takeIntegerInput(0);
        doWithdraw(account,amount);
    }

    //EFFECTS: takes an amount and deposits that amount of money in the account
    public void deposit(Account account) {
        int amount;
        System.out.println("Enter Amount you want to deposit");
        amount = takeIntegerInput(0);
        doDeposit(account,amount);
    }

    //EFFECTS: exits the function
    public void quit() {
        runProgram = false;
        System.out.println("Quitting");
        saveAccountsData();
        input.close();
    }



    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doDeposit(Account account, int amount) {
        try {
            account.deposit(amount);
            System.out.println("Successfully deposited " + amount);
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doWithdraw(Account account, int amount) {
        try {
            account.withdraw(amount);
            System.out.println("Successfully withdrew " + amount);
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance");
        }
    }

    //EFFECTS: Takes string input from user
    private String getUserInputString() {
        String text = "";
        if (input.hasNext()) {
            text = input.nextLine();
        }
        return text;
    }


    // MODIFIES: amount
    // EFFECTS: Takes integer input from user.
    private int takeIntegerInput(int amount) {
        boolean isInt;
        do {
            if (input.hasNextInt()) {
                amount = input.nextInt();
                isInt = true;
            } else {
                isInt = false;
                input.next();
            }
        } while (!isInt);
        return amount;
    }

    // EFFECTS: Print command instructions
    private void printInstructions() {
        System.out.println("Choose 1 to withdraw money");
        System.out.println("Choose 2 to deposit money");
        System.out.println("Choose 3 to check balance");
        System.out.println("Choose 4 to Logout");
        System.out.println("Choose 5 to Exit");
    }

    // EFFECTS: saves accounts' data to file
    private void saveAccountsData() {
        try {
            jsonWriter.open();
            jsonWriter.write(accounts);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: load accounts' data to file
    private void loadAccountsData() {
        try {
            accounts = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


}



