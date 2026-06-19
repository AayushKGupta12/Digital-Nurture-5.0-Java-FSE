package module1.adapterpattern;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs " + amount + " processed using PayPal.");
    }
}

class RajourGateway{
    public void makePayment(double amount){
        System.out.println("Payment of Rs " + amount + " Processed using Rajoupay");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of Rs " + amount + " processed using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.pay(amount);
    }
}

class RajourpayAdapter implements PaymentProcessor{

    private RajourGateway rajourGateway;

    public RajourpayAdapter(RajourGateway rajourGateway){
        this.rajourGateway = rajourGateway;
    }

    @Override
    public void processPayment(double amount){
        rajourGateway.makePayment(amount);
    }

}

public class Main {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        PaymentProcessor rajourpay = new RajourpayAdapter(new RajourGateway());

        paypal.processPayment(1500);

        stripe.processPayment(2500);

        rajourpay.processPayment(120305);
    }
}