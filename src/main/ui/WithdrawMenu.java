package ui;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidException;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a WithdrawMenu in the GUI
public class WithdrawMenu extends Menu implements ActionListener {
    JButton withdrawButton;
    JTextField enterAmountField;
    JLabel enterAmountLabel;
    private Account account;

    // EFFECTS: Constructs a DepositMenu and initialize an account
    public WithdrawMenu(Account account) {
        this.account = account;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
    }

    // EFFECTS: Assigns actions to all the buttons in current frame.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                Integer withdrawAmount = Integer.parseInt(enterAmountField.getText());
                account.withdraw(withdrawAmount);
                JOptionPane.showMessageDialog(this, "Successfully Withdrawn: " + withdrawAmount);
                dispose();
            } catch (NumberFormatException | InvalidException exception) {
                new ErrorClip();
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            } catch (InsufficientBalanceException insufficientBalanceException) {
                new ErrorClip();
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons and labels in current frame
    @Override
    protected void initializeButtonsAndLabels() {
        enterAmountLabel = new JLabel("Enter Withdraw Amount");
        enterAmountLabel.setBounds(80, 70, 300, 40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80, 120, 230, 50);
        enterAmountField.setFont(new Font("Amount", Font.BOLD, 20));
        this.add(enterAmountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(80, 200, 230, 75);
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);
        withdrawButton.setFont(new Font("Withdraw", Font.BOLD, 20));
        this.add(withdrawButton);
    }
}
