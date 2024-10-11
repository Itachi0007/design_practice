package org.encapsulation;


public class Driver {
    public static void main(String[] args) {
        System.out.println("Teaching Encapsulation!");

        var account = new Account();
        // DO NOT LET ANY OTHER CLASS CHANGE THE ATTRIBUTE OF THEE OBJECT -- ENCAPSULATE
        // account.balance=-2
        account.setBalance(-2);

        System.out.println(account.getBalance());


    }
}