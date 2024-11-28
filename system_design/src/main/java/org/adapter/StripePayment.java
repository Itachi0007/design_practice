package org.adapter;

// Stripe has their own payment class which will not let us make payment directly
// so we need a new Adapter class
public class StripePayment {
    public void sendMoney(int dollars) {
        System.out.println("Money sent - $" + dollars);
    }
}
