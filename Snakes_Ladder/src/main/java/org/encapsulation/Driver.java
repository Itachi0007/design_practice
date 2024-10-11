package org.games;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        var account = new Account();
        account.setBalance(-2);

        System.out.println(account.getBalance());


    }
}