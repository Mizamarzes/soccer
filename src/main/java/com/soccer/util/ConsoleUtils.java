package com.soccer.util;

public class ConsoleUtils {
    // Method to clear the console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

