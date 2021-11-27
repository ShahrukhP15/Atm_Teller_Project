package ui;

import model.Account;
import model.AllAccounts;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Represents MainMenu frame in the GUI
public class MainMenu extends Menu implements ActionListener {
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton logoutButton;
    private Account account;
    private AllAccounts accounts;
    private JLabel accountNameLabel;
    private JButton saveButton;

    // EFFECTS: Constructs a MainMenu and initialize accounts
    public MainMenu(Account account, AllAccounts accounts) {
        super();
        this.account = account;
        this.accounts = accounts;
    }

    // EFFECTS: Assigns actions to all the buttons in current frame.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            System.out.println("Enter Deposit Amount");
            new DepositMenu(account);
        } else if (e.getSource() == withdrawButton) {
            System.out.println("Enter Withdraw Amount");
            new WithdrawMenu(account);
        } else if (e.getSource() == logoutButton) {
            new LoginMenu(accounts);
            dispose();
        } else if (e.getSource() == checkBalanceButton) {
            int balance = account.getBalance();
            JOptionPane.showMessageDialog(this, "Your current balance: " + balance);
        } else if (e.getSource() == saveButton) {
            saveAccountData();
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize all the labels in current frame
    public void initializeLabels() {
        accountNameLabel = new JLabel("Welcome");
        accountNameLabel.setBounds(220, 50, 320, 25);
        accountNameLabel.setFont(new Font(accountNameLabel.getFont().getName(), Font.BOLD, 30));
        accountNameLabel.setForeground(Color.DARK_GRAY);
        this.add(accountNameLabel);
    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons in current frame
    private void initializeButtons() {
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        withdrawButton.setBounds(50, 130, 220, 100);
        withdrawButton.setFocusable(false);
        withdrawButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        this.add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        depositButton.setBounds(300, 130, 220, 100);
        depositButton.setFocusable(false);
        depositButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        this.add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(this);
        checkBalanceButton.setBounds(180, 270, 220, 100);
        checkBalanceButton.setFocusable(false);
        checkBalanceButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        this.add(checkBalanceButton);
    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons and labels in current frame
    @Override
    protected void initializeButtonsAndLabels() {
        initializeLabels();
        initializeButtons();
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        logoutButton.setBounds(380, 420, 150, 50);
        logoutButton.setFocusable(false);
        logoutButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        this.add(logoutButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setBounds(70, 420, 150, 50);
        saveButton.setFocusable(false);
        saveButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        this.add(saveButton);


    }

    // EFFECTS: Save the weeks' data to file.
    private void saveAccountData() {
        try {
            JsonWriter jsonWriter = DashboardGUI.JSON_WRITER;
            jsonWriter.open();
            jsonWriter.write(accounts);
            jsonWriter.close();
            System.out.println("Data saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + DashboardGUI.JSON_STORE);
        }
    }

}





