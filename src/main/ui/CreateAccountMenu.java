package ui;

import model.AllAccounts;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//Represents a menu to create new accounts
public class CreateAccountMenu extends Menu implements ActionListener {
    private AllAccounts accounts;
    private JButton createAccountButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameField;
    private JTextField passwordField;
    private JButton backButton;
    private JsonWriter jsonWriter;

    // EFFECTS: Constructs a CreateAccountMenu and initialize accounts
    public CreateAccountMenu(AllAccounts accounts) {
        super();
        this.accounts = accounts;
    }

    // EFFECTS: Assigns actions to all the buttons in current frame.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {
            String username = userNameField.getText();
            String password = passwordField.getText();
            accounts.addAccount(username, password);
            saveAccountData();
            JOptionPane.showMessageDialog(this, "Account successfully created.");
            new LoginMenu(accounts);
            dispose();
        }
        if (e.getSource() == backButton) {
            new LoginMenu(accounts);
            dispose();
        }
    }


    // MODIFIES: this
    // EFFECTS: initialize all the buttons and labels in current frame
    @Override
    protected void initializeButtonsAndLabels() {
        addLabels();
        addButton();
        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: initialize all the labels and text fields in current frame
    private void addLabels() {
        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(50, 70, 200, 40);
        userNameLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        this.add(userNameLabel);


        userNameField = new JTextField(30);
        userNameField.setBounds(240, 70, 250, 40);
        this.add(userNameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 120, 200, 40);
        passwordLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        this.add(passwordLabel);


        passwordField = new JTextField(30);
        passwordField.setBounds(240, 120, 250, 40);
        this.add(passwordField);

    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons in current frame
    private void addButton() {
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(220, 220, 200, 50);
        createAccountButton.setFocusable(false);
        createAccountButton.addActionListener(this);
        createAccountButton.setFont(new Font("Submit", Font.BOLD, 20));
        this.add(createAccountButton);

        backButton = new JButton("Back");
        backButton.setBounds(450, 400, 90, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(new Font("Withdraw", Font.BOLD, 20));
        this.add(backButton);
    }


    // EFFECTS: Save the accounts' data to file.
    private void saveAccountData() {
        try {
            jsonWriter = DashboardGUI.JSON_WRITER;
            jsonWriter.open();
            jsonWriter.write(accounts);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + DashboardGUI.JSON_STORE);
        }
    }
}
