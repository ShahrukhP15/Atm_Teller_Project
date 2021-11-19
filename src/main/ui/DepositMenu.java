package ui;

import exceptions.InvalidAmountException;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositMenu extends JFrame implements ActionListener {
    JLabel enterAmountLabel = new JLabel("Enter Deposit Amount");
    JTextField enterAmountField;
    JButton depositButton;
    private Account account;

    public DepositMenu(Account account) {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("ATM Interface");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(205, 236, 245));
        this.account = account;
        addLabel();
        addButton();
    }

    private void addLabel() {
        enterAmountLabel.setBounds(80, 70, 200, 40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80, 120, 200, 50);
        enterAmountField.setFont(new Font("Amount", Font.BOLD, 20));
        this.add(enterAmountField);
    }

    private void addButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(80, 200, 250, 75);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        depositButton.setFont(new Font("Deposit", Font.BOLD, 20));
        this.add(depositButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            try {
                Integer depositAmount = Integer.parseInt(enterAmountField.getText());
                account.deposit(depositAmount);
                dispose();
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            } catch (InvalidAmountException invalidAmountException) {
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            }
        }
    }
}
