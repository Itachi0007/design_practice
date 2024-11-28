package org.adapter;

public class PaypalProcessor implements PaymentProcessor{
    @Override
    public void makePayment(int amount) {
        System.out.println("Made a payment of $" + amount);
    }
}
