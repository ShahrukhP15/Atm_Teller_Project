package ui;

import model.Event;
import model.EventLog;

//runs the program
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");
        new DashboardGUI();

        //Prints out the log events on close.
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                for (Event next : EventLog.getInstance()) {
                    System.out.println(next.toString() + "\n" );
                }
            }
        }));
    }
}



