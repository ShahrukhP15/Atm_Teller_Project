package ui;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawMenu extends Menu implements ActionListener {
    JButton withdrawButton;
    JTextField enterAmountField;
    JLabel enterAmountLabel;
    private Account account;

    public WithdrawMenu(Account account) {
        this.account = account;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                Integer withdrawAmount = Integer.parseInt(enterAmountField.getText());
                account.withdraw(withdrawAmount);
                dispose();
            } catch (NumberFormatException | InvalidAmountException exception) {
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            } catch (InsufficientBalanceException insufficientBalanceException) {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
        }
    }

    @Override
    protected void initializeButtonsAndLabels() {
        enterAmountLabel = new JLabel("Enter Withdraw Amount");
        enterAmountLabel.setBounds(80, 70, 300, 40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80, 120, 280, 50);
        enterAmountField.setFont(new Font("Amount", Font.BOLD, 20));
        this.add(enterAmountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(80, 200, 250, 75);
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);
        withdrawButton.setFont(new Font("Withdraw", Font.BOLD, 20));
        this.add(withdrawButton);

    }
}
