package Week_1.module1.strategypattern;
interface PaymentStrategy {
    void pay(double amount);
}


class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}


class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentContext payment;

        payment = new PaymentContext(new CreditCardPayment());
        payment.executePayment(5000);

        payment = new PaymentContext(new PayPalPayment());
        payment.executePayment(7500);
    }
}