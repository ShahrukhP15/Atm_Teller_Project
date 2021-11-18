package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositMenu extends JFrame implements ActionListener {
    JLabel enterAmountLabel = new JLabel("Enter Deposit Amount");
    JTextField enterAmountField;
    JButton depositButton;
    JButton backButton;

    public DepositMenu() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("ATM Interface");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(205, 236, 245));

        addLabel();
        addButton();
    }

    private void addLabel() {
        enterAmountLabel.setBounds(80, 70, 270,40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80,120,280,50);
        enterAmountField.setFont(new Font("Amount",Font.BOLD, 20));
        this.add(enterAmountField);
    }

    private void addButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(80,200, 250,75);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        depositButton.setFont(new Font("Deposit", Font.BOLD,20));
        this.add(depositButton);

        backButton = new JButton("Back");
        backButton.setBounds(450,400, 100,75);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(new Font("Withdraw", Font.BOLD,20));
        this.add(backButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
