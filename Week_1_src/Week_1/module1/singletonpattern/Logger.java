package Week_1.module1.singletonpattern;

public class Logger {

    // Stores the single instance of Logger
    private static Logger instance;

    // Private constructor prevents object creation using 'new'
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Returns the same Logger object every time
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to display log messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}