package ui;

import model.Account;
import model.AllAccounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame implements ActionListener {
    private AllAccounts accounts;
    private Account account;
    private JButton submitButton;
    private JButton signUpButton;
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField usernameField;
    private JTextField passwordField;

    public LoginMenu(Account account, AllAccounts accounts) {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("ATM Interface");
        this.account = account;
        this.accounts = accounts;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(205, 236, 245));

        addLabels();
        addSubmitButton();
        addSignUpButton();
    }

    private void addLabels() {
        usernameLabel.setBounds(80, 70, 200,40);
        usernameLabel.setFont(new Font("Username", Font.BOLD, 20));
        this.add(usernameLabel);

        usernameField = new JTextField(30);
        usernameField.setBounds(200,70,250,40);
        usernameField.setText("Username");
        this.add(usernameField);


        passwordLabel.setBounds(80, 120, 200,40);
        passwordLabel.setFont(new Font("Password", Font.BOLD, 20));
        this.add(passwordLabel);


        passwordField = new JTextField(30);
        passwordField.setBounds(200,120,250,40);
        passwordField.setText("Password");
        this.add(passwordField);

    }

    private void addSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setBounds(210,180, 200,50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBackground(Color.lightGray);
        submitButton.setFont(new Font("Submit", Font.BOLD,20));
        this.add(submitButton);
    }

    private void addSignUpButton() {
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(150,300, 300,100);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);
        signUpButton.setBackground(Color.CYAN);
        signUpButton.setFont(new Font(Font.DIALOG, Font.BOLD,20));
        this.add(signUpButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
