package org.adapter;

public class Main {
    public static void main(String[] args) {
        var paypalProcessor = new PaypalProcessor();
        paypalProcessor.makePayment(20);

        var stripePayment = new StripePayment();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripePayment);
        stripeProcessor.makePayment(20);
    }
}
