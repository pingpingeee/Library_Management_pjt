package com.lmpjt.pilotpjt.controller.util;

import java.util.Scanner;


public class ConsoleCommandListener implements Runnable {

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine().trim();

                if ("online".equals(command)) {
                    ConnectionTracker.printConnections();
                } else {
                    System.out.println("not command" + command);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        Thread consoleThread = new Thread(new ConsoleCommandListener());
        consoleThread.setDaemon(true);
        consoleThread.start();
    }
}
