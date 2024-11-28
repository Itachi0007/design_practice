package org.adapter;

// Adapter says to the weird class, come I'll make an object of you, and they will only
// talk to you through me. I'll tell you what functions to do in their language
// But they have to give me an instance of your class
public class StripeAdapter implements PaymentProcessor{
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void makePayment(int amount) {
        stripePayment.sendMoney(amount);
    }
}
