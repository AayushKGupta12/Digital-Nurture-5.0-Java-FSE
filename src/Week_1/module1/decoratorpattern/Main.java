package Week_1.module1.decoratorpattern;

// Component Interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator - SMS
class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}

// Concrete Decorator - Slack
class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        System.out.println("Email Only:");
        Notifier email = new EmailNotifier();
        email.send("Server Backup Completed");

        System.out.println("\nEmail + SMS:");
        Notifier sms = new SMSNotifierDecorator(new EmailNotifier());
        sms.send("Server Backup Completed");

        System.out.println("\nEmail + SMS + Slack:");
        Notifier all = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()));

        all.send("Server Backup Completed");
    }
}