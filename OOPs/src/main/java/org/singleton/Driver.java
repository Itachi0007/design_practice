package org.singleton;

public class Driver {
    public static void main(String[] args) {
        var singleton1 = Singleton.getInstance();
        singleton1.display();

        var singleton2 = Singleton.getInstance();
        singleton2.display();

        System.out.println(singleton1==singleton2);
    }
}
