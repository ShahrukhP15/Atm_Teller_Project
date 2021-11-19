package ui;

import exceptions.InvalidAmountException;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a DepositMenu in the GUI
public class DepositMenu extends JFrame implements ActionListener {
    JLabel enterAmountLabel = new JLabel("Enter Deposit Amount");
    JTextField enterAmountField;
    JButton depositButton;
    private Account account;

    // EFFECTS: Constructs a DepositMenu and initialize an account
    public DepositMenu(Account account) {
        this.setSize(400, 400);
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

    // EFFECTS: Assigns actions to all the buttons in current frame.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            try {
                Integer depositAmount = Integer.parseInt(enterAmountField.getText());
                account.deposit(depositAmount);
                JOptionPane.showMessageDialog(this, "Successfully Deposited: " + depositAmount);
                dispose();
            } catch (NumberFormatException exception) {
                new ErrorClip();
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            } catch (InvalidAmountException invalidAmountException) {
                new ErrorClip();
                JOptionPane.showMessageDialog(this, "Enter valid input.");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize all the labels and text fields in current frame
    private void addLabel() {
        enterAmountLabel.setBounds(80, 70, 300, 40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80, 120, 210, 50);
        enterAmountField.setFont(new Font("Amount", Font.BOLD, 20));
        this.add(enterAmountField);
    }

    // MODIFIES: this
    // EFFECTS: initialize all the buttons in current frame
    private void addButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(80, 200, 230, 75);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        depositButton.setFont(new Font("Deposit", Font.BOLD, 20));
        this.add(depositButton);
    }
}
