package ui;

import model.Account;
import model.AllAccounts;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;


// Represents a table to show the accounts
public class AccountsTable extends JFrame {
    private AllAccounts accounts;
    private DefaultTableModel model;
    private JTable table;
    private JPanel panel;

    // EFFECTS: Constructs a frame with the table of accounts and initialize accounts.
    public AccountsTable(AllAccounts accounts) {
        table = new JTable();
        this.accounts = accounts;
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Account List",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        Object[] columns = {"Username", "Balance"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        addAccountData();
        JScrollPane pane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);
        this.setSize(350, 400);
        panel.add(pane);
        this.add(panel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // MODIFIES: this
    // EFFECTS : Adds account data to the table
    private void addAccountData() {
        for (Account a : accounts.getAccounts()) {
            Vector<String> result = new Vector<>();
            result.add(a.getUsername());
            Integer price = new Integer(a.getBalance());
            result.add(price.toString());
            model.addRow(result);
        }
    }

}
