package ui;

import model.Account;
import model.AllAccounts;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainMenu extends Menu implements ActionListener {
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton logoutButton;
    private JButton loadDataButton;
    private Account account;
    private AllAccounts accounts;

    // EFFECTS: Constructs a MainMenu and initialize accounts
    public MainMenu(Account account, AllAccounts accounts) {
        super();
        this.account = account;
        this.accounts = accounts;

        withdrawButton.addActionListener(this);
        withdrawButton.setBounds(50, 180, 220, 100);
        withdrawButton.setFocusable(false);
        withdrawButton.setFont(new Font("Withdraw", Font.BOLD, 20));

        depositButton.addActionListener(this);
        depositButton.setBounds(300, 180, 220, 100);
        depositButton.setFocusable(false);
        depositButton.setFont(new Font("Deposit", Font.BOLD, 20));

        checkBalanceButton.addActionListener(this);
        checkBalanceButton.setBounds(50, 320, 220, 100);
        checkBalanceButton.setFocusable(false);
        checkBalanceButton.setFont(new Font("Check Balance", Font.BOLD, 20));

    }

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
            saveAccountData();
            dispose();
        } else if (e.getSource() == checkBalanceButton) {
            int balance = account.getBalance();
            JOptionPane.showMessageDialog(this, "Your current balance: " + balance);
        }
    }


    @Override
    protected void initializeButtonsAndLabels() {
        withdrawButton = new JButton("Withdraw");
        this.add(withdrawButton);

        depositButton = new JButton("Deposit");
        this.add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        this.add(checkBalanceButton);

        loadDataButton = new JButton("Load");
        this.add(loadDataButton);

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        logoutButton.setBounds(300, 320, 220, 100);
        logoutButton.setFocusable(false);
        logoutButton.setFont(new Font("Check Balance", Font.BOLD, 20));
        this.add(logoutButton);

    }

    // EFFECTS: Save the weeks' data to file.
    private void saveAccountData() {
        try {
            JsonWriter jsonWriter = DashboardGUI.JSON_WRITER;
            jsonWriter.open();
            jsonWriter.write(accounts);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + DashboardGUI.JSON_STORE);
        }
    }

}





