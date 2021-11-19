package ui;

import exceptions.NotFoundException;
import model.Account;
import model.AllAccounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Represent a LoginMenu in the GUI
public class LoginMenu extends Menu implements ActionListener {
    private AllAccounts accounts;
    private JButton submitButton;
    private JButton signUpButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameField;
    private JTextField passwordField;
    private JButton loadDataButton;


    // EFFECTS: Constructs a LoginMenu and initialize accounts
    public LoginMenu(AllAccounts accounts) {
        super();
        this.accounts = accounts;
    }

    // EFFECTS: Assigns actions to all the buttons in current frame.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadDataButton) {
            loadData();
        }
        if (e.getSource() == submitButton) {
            String username = userNameField.getText();
            String password = passwordField.getText();
            try {
                Account account = accounts.lookupAccount(username,password);
                new MainMenu(account,accounts);
                dispose();
            } catch (NotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Account not found.");
            }
        }
        if (e.getSource() == signUpButton) {
            new CreateAccountMenu(accounts);
            dispose();
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons and labels in current frame
    @Override
    protected void initializeButtonsAndLabels() {
        addButtons();
        initializeLabels();
    }

    // MODIFIES: this
    // EFFECTS: initialize all the labels and text fields in current frame
    private void initializeLabels() {
        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(30, 40, 100, 25);
        userNameLabel.setFont(new Font(userNameLabel.getFont().getName(), Font.BOLD, 20));
        this.add(userNameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 80, 100, 25);
        passwordLabel.setFont(new Font(userNameLabel.getFont().getName(), Font.BOLD, 20));
        this.add(passwordLabel);

        userNameField = new JTextField(20);
        userNameField.setBounds(170, 40, 180, 30);
        passwordField = new JTextField(20);
        passwordField.setBounds(170, 80, 180, 30);
        this.add(userNameField);
        this.add(passwordField);
        this.revalidate();
        this.repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds all the buttons in current frame
    private void addButtons() {
        submitButton = new JButton("Login");
        submitButton.setBounds(240, 280, 100, 50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        this.add(submitButton);

        signUpButton = new JButton("Create Account");
        signUpButton.setBounds(190, 400, 200, 50);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);
        this.add(signUpButton);

        loadDataButton = new JButton("Load");
        loadDataButton.addActionListener(this);
        loadDataButton.setBounds(480, 0, 100, 50);
        loadDataButton.setFocusable(false);
        this.add(loadDataButton);
    }

    // MODIFIES: this
    // EFFECTS: load weeks' data from file in weeks.
    private void loadData() {
        try {
            accounts = DashboardGUI.JSON_READER.read();
            new AccountsTable(accounts);
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + DashboardGUI.JSON_STORE);
        }
    }


}
