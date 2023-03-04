package app;

import io.UserConsole;

/**
 * Main application class. Initializes the console.
 */
public class MainClass {
    public static void main(String[] args) {
        UserConsole.init();
        UserConsole.interact();
    }
}
