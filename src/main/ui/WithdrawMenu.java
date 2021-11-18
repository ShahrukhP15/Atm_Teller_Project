package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawMenu extends Menu implements ActionListener {
    JButton withdrawButton;
    JTextField enterAmountField;
    JLabel enterAmountLabel;
    JButton backButton;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    protected void initializeButtonsAndLabels() {
        enterAmountLabel = new JLabel("Enter Withdraw Amount");
        enterAmountLabel.setBounds(80, 70, 300,40);
        enterAmountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        this.add(enterAmountLabel);

        enterAmountField = new JTextField(30);
        enterAmountField.setBounds(80,120,280,50);
        enterAmountField.setFont(new Font("Amount",Font.BOLD, 20));
        this.add(enterAmountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(80,200, 250,75);
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);
        withdrawButton.setFont(new Font("Withdraw", Font.BOLD,20));
        this.add(withdrawButton);

        backButton = new JButton("Back");
        backButton.setBounds(450,400, 100,75);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(new Font("Withdraw", Font.BOLD,20));
        this.add(backButton);
    }
}
