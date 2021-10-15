package ui;

import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

// A Dashboard for user to interact and give inputs

public class Dashboard {
    public void instructions() {
        System.out.println("Choose 1 to withdraw money");
        System.out.println("Choose 2 to deposit money");
        System.out.println("Choose 3 to check balance");
        System.out.println("Choose 4 to Exit");
    }

    public static void runProgram(ArrayList<Account> accounts, Account account, Scanner sc) {
        System.out.println("Enter initial amount");
        int x = sc.nextInt();
        account.deposit(x);
        Dashboard myInput = new Dashboard();
        while (true) {
            myInput.instructions();
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Enter Amount you want to withdraw");
                account.withdraw(sc.nextInt());
            } else if (n == 2) {
                System.out.println("Enter Amount you want to deposit");
                int temp = sc.nextInt();
                account.deposit(temp);
            } else if (n == 3) {
                System.out.println(account.getBalance());
            } else if (n == 4) {
                break;
            } else {
                System.out.println("Enter a valid command!");
            }
        }
    }
}
