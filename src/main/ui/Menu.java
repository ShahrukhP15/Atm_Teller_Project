package ui;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;

public abstract class Menu extends JFrame {
    // EFFECTS: Constructs a menu  and instantiates a frame
    public Menu() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("ATM Interface");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(205, 236, 245));
        initializeButtonsAndLabels();
    }

    // EFFECTS: initialize all the buttons and labels in current frame
    protected abstract void initializeButtonsAndLabels();
}
