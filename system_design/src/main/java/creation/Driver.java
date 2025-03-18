package creation;

public class Driver {
    // As we start the application a "main thread" is created by JVM which starts our program execution
    public static void main(String[] args) {
        // There are 2 ways to create a thread in java

        // Method 1 - Using a runnable object
        MyThreadByRunnable runnableObj = new MyThreadByRunnable();
        Thread t1 = new Thread(runnableObj);
        t1.start();

        // Method 2 - Using a class which extends Thread
        MyThreadByExtending t2 = new MyThreadByExtending();
        t2.start();

        // This is because a class can extend only 1 parent class but multiple interfaces
        // Generally we use Method-1 for operating with threads

        // Note that my Extending class is a thread itself.
        // But my Runnable class is not a thread,
        // it can just be run by a thread whose target is my runnable class's object
    }
}
