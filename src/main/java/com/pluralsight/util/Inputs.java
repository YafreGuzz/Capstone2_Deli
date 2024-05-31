package com.pluralsight.util;

import java.util.Scanner;

public class Inputs {
    private static Scanner scanner;

    private Inputs() {
    }

    public static void openScanner() {

        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static void ensureScannerIsOpen() {
        if (scanner == null) {
            openScanner();
        }
    }

    public static String getString() {
        ensureScannerIsOpen();
        return scanner.nextLine();
    }

    public static int getInt() {
        ensureScannerIsOpen();
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number... Please enter an integer:");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static void awaitInput() {
        ensureScannerIsOpen();
        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
