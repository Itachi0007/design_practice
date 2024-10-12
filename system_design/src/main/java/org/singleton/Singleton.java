package org.singleton;

// NOTE THAT THIS IS A LAZY INITIALIZATION OF SINGLETON CLASS

public class Singleton {
    // a private static instance of the class type
    private static Singleton instance;

    // a private constructor
    private Singleton() {}

    public static Singleton getInstance() {
        // check if current instance is null by mistake
        if(instance==null) {
            // return new Singleton();
            instance = new Singleton();
            System.out.println("Delivering new instance");
        }

        return instance;
    }

    public void display() {
        System.out.println("I'm a Singleton class");
    }
}
