package ui;

import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

//runs the program

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Account myAccount = new Account(0);
        myAccount.setUsername("abc");
        myAccount.setPassword(123);
        accounts.add(myAccount);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.next();
        System.out.println("Enter password:");
        int password = sc.nextInt();
        
        checkCredentials(accounts,username,password,sc);
        Dashboard.runProgram(accounts, myAccount, sc);
    }



    private static boolean findUser(ArrayList<Account> accounts,String username,int password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && (account.getPassword() == password)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static void checkCredentials(ArrayList<Account> accounts,String username,int password,Scanner sc) {
        while (true) {
            if (findUser(accounts,username,password)) {
                break;
            } else if (username == "") {
                System.out.println("Enter username:");
                username = sc.next();
                System.out.println("Enter password");
                password = sc.nextInt();
            } else {
                System.out.println("Not found");
                System.out.println("Enter username:");
                username = sc.next();
                System.out.println("Enter password");
                password = sc.nextInt();
            }
        }
    }
}


